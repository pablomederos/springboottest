package com.pgmsoft.profesores.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pgmsoft.profesores.dao.CourseDao;
import com.pgmsoft.profesores.model.Course;

@Repository
@Transactional
public class CourseDaoImpl extends AbstractSession implements CourseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void saveCourse(Course course) {

		getSession().persist(course);
	}

	@Override
	public void deleteCourse(Integer id) {
		Course course = getSession().get(Course.class, id);
		Optional.of(course).ifPresent(c -> getSession().delete(course));
	}

	@Override
	public void updateCourse(Course course) {
		getSession().update(course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> listAll() {
		return getSession().createQuery("from Course").list();
	}

	@Override
	public Course findById(Integer id) {
		return getSession().get(Course.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findCourseByName(String name) {
		
		return getSession().createQuery("from Course where name = :name").setParameter("name", name).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findCourseByIdTeacher(Integer id) {

		return getSession()
				.createQuery("from Course c join c.teacher t on t.id_teacher = :id")
				.setParameter("id", id)
				.list();
	}

}
