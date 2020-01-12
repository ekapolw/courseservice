package com.technicallab.courseservice.componenttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicallab.courseservice.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseAdminServiceComponentTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  public void whenAddCourseThenReturnCourse() throws Exception {
    Course course = new Course("MATH101", "Math");

    System.out.println(objectMapper.writeValueAsString(course));

    MvcResult result =
        mockMvc
            .perform(
                post("/course_admin/addCourse")
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(course)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String contentAsString = result.getResponse().getContentAsString();
    Course enrolledCourse = objectMapper.readValue(contentAsString, Course.class);

    assertEquals(1, enrolledCourse.getId().longValue());
    assertEquals("Math", enrolledCourse.getName());
  }

  @Test
  public void whenListCoursesThenReturnCourseList() throws Exception {

    MvcResult result =
        mockMvc
            .perform(
                get("/course_admin/listCourses")
                    .contentType("application/json"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String contentAsString = result.getResponse().getContentAsString();
    assertNotEquals("[]", contentAsString);

  }

}
