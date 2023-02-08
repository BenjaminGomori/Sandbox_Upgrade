package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.entity.*;

import java.util.List;

public interface IOrchestratorService {
    List<PublicCourse> getUserCourses(String usrerId);
    List<PublicVM> getUserVMs(String usrerId);
    void getStarted() throws Exception;
    public void assignLabCourse(Lab lab, int courseId);
    public Student findStudentByUsername(String username);
    public Instructor findInstructorByUsername(String username);
//    void setUserType(String username);
    public String getUserType(String username);
}