package com.technicallab.courseservice.unittest;

import static org.junit.Assert.assertEquals;


import com.technicallab.courseservice.domain.CourseAdminDomain;
import org.junit.Before;
import org.junit.Test;

public class CourseAdminDomainTest {

  private CourseAdminDomain courseAdminDomain;

  @Before
  public void initialDomain() {
    courseAdminDomain = new CourseAdminDomain();
  }

  @Test
  public void givenNormalWhenCheckHealthThenReturnNa() {
    assertEquals("Admin Service is up na.", courseAdminDomain.healthCheck("NORMAL"));
  }

  @Test
  public void givenSweetWhenCheckHealthThenReturnNaJa() {
    assertEquals("Admin Service is up na ja.", courseAdminDomain.healthCheck("SWEET"));
  }

  @Test
  public void givenSpicyWhenCheckHealthThenReturnNothing() {
    assertEquals("", courseAdminDomain.healthCheck("SPICY"));
  }

}
