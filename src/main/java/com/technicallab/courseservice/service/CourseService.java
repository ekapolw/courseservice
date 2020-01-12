package com.technicallab.courseservice.service;

import com.technicallab.courseservice.entities.EnrolledCourse;
import com.technicallab.courseservice.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  private CourseRepository courseRepository;

  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public EnrolledCourse enrollCourse(EnrolledCourse enrolledCourse) {
    return courseRepository.save(enrolledCourse);
  }

  public List<EnrolledCourse> listEnrolledCourses() {
    List<EnrolledCourse> enrolledCourses = new ArrayList<>();
    courseRepository.findAll().forEach(enrolledCourses::add);
    return enrolledCourses;
  }
}
