package com.pgmsoft.profesores.service;

import java.io.Serializable;
import java.util.List;

import com.pgmsoft.profesores.model.SocialMedia;
import com.pgmsoft.profesores.model.TeacherSocialMedia;

public interface SocialMediaService extends Serializable {

	List<SocialMedia> listAll();

	SocialMedia findSocialMediaById(Integer id);

	void deleteSocialMediaById(Integer id);

	void updateSocialMedia(SocialMedia socialMedia);

	void saveSocialMedia(SocialMedia socialMedia);

	List<SocialMedia> findSocialMediaByName(String name);

	TeacherSocialMedia findSocialMediaByIdAndName(Integer id, String nickname);
}
