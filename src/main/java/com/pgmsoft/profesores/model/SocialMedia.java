package com.pgmsoft.profesores.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="social_media")
public class SocialMedia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idsocial_media")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idsocial_media;
	
	@Column(name="name")
	private String name;
	@Column(name="icono")
	private String icon;
	
	@OneToMany
	@JoinColumn(name="idsocial_media")
	@JsonIgnore
	private Set<TeacherSocialMedia> teacherSocialMedia;
	
	public SocialMedia(String name, String icon) {
		
		this.name = name;
		this.icon = icon;
	}
	public SocialMedia() {
		
	}
	
	public Integer getIdsocial_media() {
		return idsocial_media;
	}
	public void setIdsocial_media(Integer idsocial_media) {
		this.idsocial_media = idsocial_media;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Set<TeacherSocialMedia> getTeacherSocialMedia() {
		return teacherSocialMedia;
	}
	public void setTeacherSocialMedia(Set<TeacherSocialMedia> teacherSocialMedia) {
		this.teacherSocialMedia = teacherSocialMedia;
	}
	
	
}
