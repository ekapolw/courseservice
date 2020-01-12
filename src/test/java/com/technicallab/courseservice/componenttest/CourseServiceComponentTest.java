package com.technicallab.courseservice.componenttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicallab.courseservice.entities.EnrolledCourse;
import org.junit.BeforeClass;
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
public class CourseServiceComponentTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  static private String INPUT_JSON = "";

  @BeforeClass
  public static void initiateInputJson() {

    INPUT_JSON = "{"
        + "\"courseId\":1,"
        + "\"courseCode\":\"MATH001\","
        + "\"courseName\":\"Math\","
        + "\"studentId\":\"11049392\","
        + "\"studentName\":\"Ekapol\","
        + "\"studentTeam\":\"Quality Excellence\""
        + "}";
  }

  @Test
  public void whenEnrollCourseThenReturnEnrolledCourse() throws Exception {

    MvcResult result =
        mockMvc
            .perform(
                post("/course/enrollCourse")
                    .contentType("application/json")
                    .content(INPUT_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String contentAsString = result.getResponse().getContentAsString();
    EnrolledCourse enrolledCourse = objectMapper.readValue(contentAsString, EnrolledCourse.class);

    assertEquals(enrolledCourse.getCourseId().longValue(), 1);
  }

  @Test
  public void whenListEnrolledCoursesThenReturnCourseList() throws Exception {

    mockMvc
        .perform(
            post("/course/enrollCourse")
                .contentType("application/json")
                .content(INPUT_JSON))
        .andExpect(status().isOk());

    MvcResult result =
        mockMvc
            .perform(
                get("/course/listEnrolledCourses")
                    .contentType("application/json"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    String contentAsString = result.getResponse().getContentAsString();
    System.out.println("String is :" + contentAsString);
    assertNotEquals("[]", contentAsString);

  }
}
