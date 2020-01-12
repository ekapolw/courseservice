package com.technicallab.courseservice.repository;

import com.technicallab.courseservice.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseAdminRepository extends CrudRepository<Course, Long> {
}
