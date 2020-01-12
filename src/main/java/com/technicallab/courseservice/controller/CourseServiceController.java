package com.technicallab.courseservice.controller;

import com.technicallab.courseservice.entities.EnrolledCourse;
import com.technicallab.courseservice.service.CourseService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseServiceController {

  private CourseService courseService;

  @Autowired
  public CourseServiceController(CourseService courseService) {
    this.courseService = courseService;
  }

  @PostMapping(path = "/course/enrollCourse")
  public EnrolledCourse enrollCourse(@Valid @RequestBody EnrolledCourse enrolledCourse) {
    return courseService.enrollCourse(enrolledCourse);
  }

  @GetMapping(path = "/course/listEnrolledCourses")
  public List<EnrolledCourse> listEnrolledCourses() {
    return courseService.listEnrolledCourses();
  }
}
