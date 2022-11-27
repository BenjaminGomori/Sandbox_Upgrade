package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Course;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("test")
public class CourseDAOStub implements ICourseDAO {

    Map<Integer, Course> courses = new HashMap<>();

    @Override
    public Course fetch(int courseID) {
        return courses.get(courseID);
    }

    @Override
    public Iterable<Course> fetchAll() {
        List<Course> returnCourses = new ArrayList(courses.values());
        return returnCourses;
    }
}