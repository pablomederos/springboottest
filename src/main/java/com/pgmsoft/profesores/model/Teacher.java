package com.pgmsoft.profesores.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_teacher")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_teacher;
	
	@Column(name="name")
	private String name;
	@Column(name="avatar")
	private String avatar;
	
	@OneToMany(mappedBy="teacher")
	private Set<Course> courses;
	
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="id_teacher")
	private Set<TeacherSocialMedia> teacherSocialMedia;
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String avatar) {
		super();
		this.name = name;
		this.avatar = avatar;
	}
	
	public Integer getId_teacher() {
		return id_teacher;
	}
	public void setId_teacher(Integer id_teacher) {
		this.id_teacher = id_teacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<TeacherSocialMedia> getTeacherSocialMedia() {
		return teacherSocialMedia;
	}

	public void setTeacherSocialMedia(Set<TeacherSocialMedia> teacherSocialMedia) {
		this.teacherSocialMedia = teacherSocialMedia;
	}

	@Override
	public String toString() {
		return "Teacher [id_teacher=" + id_teacher + ", name=" + name + ", avatar=" + avatar + "]";
	}
}
