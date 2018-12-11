package com.pgmsoft.profesores.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pgmsoft.profesores.model.*;
import com.pgmsoft.profesores.service.*;

@Controller
@RequestMapping("/v1")
public class SocialMediaController {
	
	@Autowired
	SocialMediaService socialMediaSvc;

	@RequestMapping(value="/socialMedia", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<SocialMedia>> getSocialMedia (){
		List<SocialMedia> socialMedia = new ArrayList<>();
		socialMedia = socialMediaSvc.listAll();
		
		if(socialMedia.isEmpty()) {
			return new ResponseEntity<List<SocialMedia>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SocialMedia>>(socialMedia, HttpStatus.OK);
	}
	
	
}
