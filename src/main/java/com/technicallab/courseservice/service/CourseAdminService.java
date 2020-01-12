package com.technicallab.courseservice.service;

import com.technicallab.courseservice.entities.Course;
import com.technicallab.courseservice.repository.CourseAdminRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdminService {

  private CourseAdminRepository courseAdminRepository;

  @Autowired
  public CourseAdminService(CourseAdminRepository courseAdminRepository) {
    this.courseAdminRepository = courseAdminRepository;
  }

  public Course add(Course course) {
    return courseAdminRepository.save(course);
  }

  public List<Course> listCourses() {
    List<Course> courses = new ArrayList<>();
    courseAdminRepository.findAll().forEach(courses::add);
    return courses;
  }
}
