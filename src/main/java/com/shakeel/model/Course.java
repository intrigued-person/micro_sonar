package com.shakeel.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	private String courseName;

	@OneToMany(targetEntity = Application.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.DETACH })
	@JoinColumn(name = "cors_fk", referencedColumnName = "courseId")
	private List<Application> applications = new ArrayList<>();

	public Course() {
		super();
	}

	public Course(int courseId, String courseName, List<Application> applications) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.applications = applications;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
