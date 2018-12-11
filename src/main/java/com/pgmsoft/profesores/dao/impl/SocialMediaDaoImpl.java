package com.pgmsoft.profesores.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgmsoft.profesores.dao.SocialMediaDao;
import com.pgmsoft.profesores.model.SocialMedia;
import com.pgmsoft.profesores.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialMedia> listAll() {

		return getSession().createQuery("from SocialMedia").getResultList();
	}

	@Override
	public SocialMedia findSocialMediaById(Integer id) {

		return getSession().getReference(SocialMedia.class, id);
	}

	@Override
	public void deleteSocialMediaById(Integer id) {

		SocialMedia socialmedia = findSocialMediaById(id);
		Optional.of(socialmedia).ifPresent(
					s -> getSession().remove(socialmedia)
				);
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {

		getSession().refresh(socialMedia);
	}

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		
		getSession().persist(socialMedia);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Integer id, String nickname) {
		
		@SuppressWarnings("unchecked")
		List<Object[]> objects = getSession()
				.createQuery("from TeacherSocialMedia ts join SocialMedia s on ts.idsocial_media = :id and "
						+ "ts.nickname = :nickname")
				.setParameter("id", id)
				.setParameter("nickname", nickname)
				.getResultList();
		
		if(objects.size() > 0) {
			for(Object[] obj: objects) {
				for(Object object: obj) {
					if (object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialMedia> findSocialMediaByName(String name) {

		return getSession().createQuery("from SocialMedia where name = :name")
				.setParameter("name", name).getResultList();
	}

}
