package com.pgmsoft.profesores.service;

import java.io.Serializable;
import java.util.List;

import com.pgmsoft.profesores.model.Teacher;

public interface TeacherService extends Serializable {

	void saveTeacher(Teacher teacher);

	List<Teacher> findAllTeachers();

	Teacher findTeacherById(Integer id);

	List<Teacher> findTeacherByName(String name);

	void deleteTeacherById(Integer id);

	void updateTeacher(Teacher teacher);
}
