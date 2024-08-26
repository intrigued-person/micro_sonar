package com.shakeel.repoimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shakeel.model.Course;
import com.shakeel.repo.CourseRepo;

import jakarta.persistence.EntityManager;

@Repository
public class CourseRepoImp implements CourseRepo{
	
	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourse() {
		return em.createQuery("SELECT c FROM Course c").getResultList();
	}

	@Override
	public boolean updateCourse(Course course) {
		em.merge(course);
		return true;
	}

	@Override
	public void deleteCourse(int id) {
		Course course=em.find(Course.class, id);
		em.remove(course);
		
	}

	@Override
	public void addCourse(Course course) {
		em.persist(course);
	}

}
