package com.pgmsoft.profesores.dao;

import java.io.Serializable;
import java.util.List;

import com.pgmsoft.profesores.model.Course;

public interface CourseDao extends Serializable {

	Course findById (Integer id);
	
	void saveCourse (Course course);
	
	void deleteCourse (Integer id);
	
	void updateCourse (Course course);
	
	List<Course> listAll ();
	
	List<Course> findCourseByName(String name);
	
	List<Course> findCourseByIdTeacher (Integer id);
}
