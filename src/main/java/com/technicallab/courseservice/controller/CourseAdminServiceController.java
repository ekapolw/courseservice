package com.technicallab.courseservice.controller;

import com.technicallab.courseservice.domain.CourseAdminDomain;
import com.technicallab.courseservice.entities.Course;
import com.technicallab.courseservice.service.CourseAdminService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseAdminServiceController {

  private CourseAdminService courseAdminService;
  private CourseAdminDomain courseAdminDomain;

  @Autowired
  public CourseAdminServiceController(
      CourseAdminService courseAdminService,
      CourseAdminDomain courseAdminDomain) {

    this.courseAdminService = courseAdminService;
    this.courseAdminDomain = courseAdminDomain;
  }

  @PostMapping(path = "/course_admin/addCourse")
  public Course addCourse(@Valid @RequestBody Course course) {
    return courseAdminService.add(course);
  }

  @GetMapping(path = "/course_admin/listCourses")
  public List<Course> listCourses() {
    return courseAdminService.listCourses();
  }

  @GetMapping(path = "/course_admin/healthcheck/{liveOrDie}")
  public String healthCheck(
      @PathVariable("liveOrDie") String liveOrDie) {

    return courseAdminDomain.healthCheck(liveOrDie);
  }

  @GetMapping(path = "/course_admin/healthcheck")
  public String healthCheck() {
    return courseAdminDomain.healthCheck("");
  }

}
