package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Course;

public interface ICourseDAO {
    Course fetch(int courseId);
    Iterable<Course> fetchAll() throws Exception;
}
