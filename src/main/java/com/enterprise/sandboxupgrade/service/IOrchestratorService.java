package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.PublicCourse;
import com.enterprise.sandboxupgrade.dto.PublicVM;

import java.util.List;

public interface IOrchestratorService {
    List<PublicCourse> getUserCourses(String usrerId);
    List<PublicVM> getUserVMs(String usrerId);
    void getStarted() throws Exception;
}