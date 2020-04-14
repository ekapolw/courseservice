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
    assertEquals("We wish to LIVE. So we live and happy.", courseAdminDomain.healthCheck("LIVE"));
  }

  @Test
  public void givenSweetWhenCheckHealthThenReturnNaJa() {
    assertEquals("We force to DIE. So we go to heaven, but you go to hell.", courseAdminDomain.healthCheck("DIE"));
  }

  @Test
  public void givenSpicyWhenCheckHealthThenReturnNothing() {
    assertEquals("What!!! We don't understand you. Please speak English.", courseAdminDomain.healthCheck(""));
  }

}
