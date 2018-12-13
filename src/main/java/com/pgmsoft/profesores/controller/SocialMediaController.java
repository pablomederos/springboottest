package com.pgmsoft.profesores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.pgmsoft.profesores.model.SocialMedia;
import com.pgmsoft.profesores.service.SocialMediaService;

@Controller
@RequestMapping("/v1")
public class SocialMediaController {

	@Autowired
	SocialMediaService socialMediaSvc;

	// GET
	@RequestMapping(value = "/socialMedia", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialMedia>> getSocialMedia() {
		List<SocialMedia> socialMedia = new ArrayList<>();
		socialMedia = socialMediaSvc.listAll();

		if (socialMedia.isEmpty()) {
			return new ResponseEntity<List<SocialMedia>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SocialMedia>>(socialMedia, HttpStatus.OK);
	}

	// GET
	@RequestMapping(value = "/socialMedia/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> getSocialMediaById(@PathVariable("id") Integer id) {
		
		if (id == null || id <= 0) {
			return new ResponseEntity<SocialMedia>(HttpStatus.NO_CONTENT);
		}
		SocialMedia socialMedia = new SocialMedia();
		socialMedia = socialMediaSvc.findSocialMediaById(id);
		
		if (socialMedia.equals(null)) {
			return new ResponseEntity<SocialMedia>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "socialMedia", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia socialMedia,
			UriComponentsBuilder uriComponentsBuilder) {
		if (socialMedia.getName().equals(null) || socialMedia.getName().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		if (socialMediaSvc.findSocialMediaByName(socialMedia.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		socialMediaSvc.saveSocialMedia(socialMedia);
		SocialMedia _socialMedia = socialMediaSvc.findSocialMediaByName(socialMedia.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/socialMedia/{id}")
				.buildAndExpand(_socialMedia.getIdsocial_media()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
