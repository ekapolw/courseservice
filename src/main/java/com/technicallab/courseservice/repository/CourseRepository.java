package com.technicallab.courseservice.repository;

import com.technicallab.courseservice.entities.EnrolledCourse;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<EnrolledCourse, Long> {
}
