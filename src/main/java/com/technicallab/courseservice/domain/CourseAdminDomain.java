package com.technicallab.courseservice.domain;

import org.springframework.stereotype.Component;

@Component
public class CourseAdminDomain {

  public String healthCheck(String liveOrDie) {

    String rtnMessage;

    if (liveOrDie.equals("LIVE")) {
      rtnMessage = "We wish to " + liveOrDie + ". So we live and happy xxx.";
    } else if (liveOrDie.equals("DIE")) {
      rtnMessage = "We force to " + liveOrDie + ". So we go to heaven, but you go to hell.";
    } else {
      rtnMessage = "What!!! We don't understand you. Please speak English.";
    }

    return rtnMessage;
  }
}
