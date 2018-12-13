package com.pgmsoft.profesores.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgmsoft.profesores.dao.SocialMediaDao;
import com.pgmsoft.profesores.model.SocialMedia;
import com.pgmsoft.profesores.model.TeacherSocialMedia;
import com.pgmsoft.profesores.service.SocialMediaService;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SocialMediaDao socialMediaDao;

	@Override
	public List<SocialMedia> listAll() {
		
		return socialMediaDao.listAll();
	}

	@Override
	public SocialMedia findSocialMediaById(Integer id) {

		return socialMediaDao.findSocialMediaById(id);
	}

	@Override
	public void deleteSocialMediaById(Integer id) {
		
		socialMediaDao.deleteSocialMediaById(id);
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		
		socialMediaDao.updateSocialMedia(socialMedia);
	}

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		
		socialMediaDao.saveSocialMedia(socialMedia);
	}

	@Override
	public SocialMedia findSocialMediaByName(String name) {
		
		return socialMediaDao.findSocialMediaByName(name);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Integer id, String nickname) {
		
		return socialMediaDao.findSocialMediaByIdAndName(id, nickname);
	}

}
