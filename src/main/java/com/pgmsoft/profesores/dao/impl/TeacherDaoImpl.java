package com.pgmsoft.profesores.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgmsoft.profesores.dao.TeacherDao;
import com.pgmsoft.profesores.model.Teacher;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

	public TeacherDaoImpl() {
		
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		getSession().persist(teacher);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAllTeachers() {
		return getSession().createQuery("from Teacher").getResultList();
	}

	@Override
	public Teacher findTeacherById(Integer id) {
		
		return getSession().getReference(Teacher.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findTeacherByName(String name) {
		
		return getSession().createQuery("from Teacher where name = :name")
				.setParameter("name", name)
				.getResultList();
	}

	@Override
	public void deleteTeacherById(Integer id) {

		Teacher teacher = findTeacherById(id);
		Optional.of(teacher).ifPresent(
					t -> getSession().remove(t)
				);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		getSession().refresh(teacher);
	}

}
