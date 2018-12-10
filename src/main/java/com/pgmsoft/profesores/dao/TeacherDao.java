package com.pgmsoft.profesores.dao;

import java.util.List;

import com.pgmsoft.profesores.model.Teacher;

public interface TeacherDao {

	void saveTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	Teacher findTeacherById(Integer id);
	
	List<Teacher> findTeacherByName(String name);
	
	void deleteTeacherById(Integer id);
	
	void updateTeacher(Teacher teacher);
}
