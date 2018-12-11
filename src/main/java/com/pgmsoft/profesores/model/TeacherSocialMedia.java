package com.pgmsoft.profesores.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher_social_media")
public class TeacherSocialMedia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idteacher_social_media")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_teacherSocialMedia;
	@Column(name="nickname")
	private String nickName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_teacher")
	private Teacher teacher;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idsocial_media")
	private SocialMedia socialMedia;
	
	public TeacherSocialMedia() {
		super();
	}

	public TeacherSocialMedia(String nickname, Teacher teacher, SocialMedia socialMedia) {
		super();
		this.teacher = teacher;
		this.socialMedia = socialMedia;
		this.nickName = nickname;
	}
	
	public Integer getId_teacherSocialMedia() {
		return id_teacherSocialMedia;
	}
	public void setId_teacherSocialMedia(Integer id_teacherSocialMedia) {
		this.id_teacherSocialMedia = id_teacherSocialMedia;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public SocialMedia getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
