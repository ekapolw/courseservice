package com.technicallab.courseservice.domain;

import org.springframework.stereotype.Component;

@Component
public class CourseAdminDomain {

  public String healthCheck(String sweetLevel) {

    String rtnMessage = "";

      if (sweetLevel.equals("NORMAL")) {
        rtnMessage = "Admin Service is up.";
    } else if (sweetLevel.equals("SWEET")) {
      rtnMessage = "Admin Service is up na ja.";
    }

    return rtnMessage;
  }
}
