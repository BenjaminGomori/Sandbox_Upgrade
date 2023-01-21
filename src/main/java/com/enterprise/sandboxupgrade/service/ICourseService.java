package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.Course;

import java.util.List;

public interface ICourseService {
    Course fetch(int courseID);
    List<Course> fetchAll() throws Exception;
}