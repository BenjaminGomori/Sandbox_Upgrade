package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.entity.Lab;
import com.enterprise.sandboxupgrade.entity.PublicCourse;
import com.enterprise.sandboxupgrade.entity.PublicVM;

import java.util.List;

public interface IOrchestratorService {
    List<PublicCourse> getUserCourses(String usrerId);
    List<PublicVM> getUserVMs(String usrerId);
    void getStarted() throws Exception;
    public void assignLabCourse(Lab lab, int courseId);
}