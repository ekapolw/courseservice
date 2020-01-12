package com.technicallab.courseservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENROLLED_COURSE")
public class EnrolledCourse {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long courseId;

  private String courseCode;

  private String courseName;

  private Long studentId;

  private String studentName;

  private String studentTeam;

  public EnrolledCourse() {}

  public EnrolledCourse(
      Long courseId,
      String courseCode,
      String courseName,
      Long studentId,
      String studentName,
      String studentTeam) {
    this.courseId = courseId;
    this.courseCode = courseCode;
    this.courseName = courseName;
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentTeam = studentTeam;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentTeam() {
    return studentTeam;
  }

  public void setStudentTeam(String studentTeam) {
    this.studentTeam = studentTeam;
  }
}
