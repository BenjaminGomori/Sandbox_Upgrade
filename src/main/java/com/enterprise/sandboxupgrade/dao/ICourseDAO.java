package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Course;

import java.util.List;

public interface ICourseDAO {
    Course fetch(int courseId);
    List<Course> fetchAll() throws Exception;
}
