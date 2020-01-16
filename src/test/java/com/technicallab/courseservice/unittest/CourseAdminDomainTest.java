package com.technicallab.courseservice.unittest;

import static org.junit.Assert.assertEquals;


import com.technicallab.courseservice.domain.CourseAdminDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CourseAdminDomainTest {

  @InjectMocks
  private CourseAdminDomain courseAdminDomain;

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
