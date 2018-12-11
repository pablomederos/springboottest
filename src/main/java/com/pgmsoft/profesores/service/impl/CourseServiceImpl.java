package com.pgmsoft.profesores.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgmsoft.profesores.dao.CourseDao;
import com.pgmsoft.profesores.model.Course;
import com.pgmsoft.profesores.service.CourseService;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public Course findById(Integer id) {
		
		return courseDao.findById(id);
	}

	@Override
	public void saveCourse(Course course) {
		
		courseDao.saveCourse(course);
	}

	@Override
	public void deleteCourse(Integer id) {
		
		courseDao.deleteCourse(id);
	}

	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}

	@Override
	public List<Course> listAll() {
		return courseDao.listAll();
	}

	@Override
	public List<Course> findCourseByName(String name) {
		
		return courseDao.findCourseByName(name);
	}

	@Override
	public List<Course> findCourseByIdTeacher(Integer id) {
		
		return courseDao.findCourseByIdTeacher(id);
	}

}
