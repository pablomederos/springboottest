package com.pgmsoft.profesores.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgmsoft.profesores.dao.TeacherDao;
import com.pgmsoft.profesores.model.Teacher;
import com.pgmsoft.profesores.service.TeacherService;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void saveTeacher(Teacher teacher) {
		
		teacherDao.saveTeacher(teacher);
	}

	@Override
	public List<Teacher> findAllTeachers() {
		
		return teacherDao.findAllTeachers();
	}

	@Override
	public Teacher findTeacherById(Integer id) {
		
		return teacherDao.findTeacherById(id);
	}

	@Override
	public List<Teacher> findTeacherByName(String name) {
		
		return teacherDao.findTeacherByName(name);
	}

	@Override
	public void deleteTeacherById(Integer id) {
		
		teacherDao.deleteTeacherById(id);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		
		teacherDao.updateTeacher(teacher);
	}

}
