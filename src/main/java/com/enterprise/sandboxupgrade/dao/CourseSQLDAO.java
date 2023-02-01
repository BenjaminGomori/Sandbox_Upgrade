package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("courseDAO")
@Profile({"dev", "default"})
public class CourseSQLDAO implements ICourseDAO {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course fetch(int eventId) {
        return courseRepository.findById(eventId).get();
    }

    @Override
    public List<Course> fetchAll() {
        List<Course> target = new ArrayList<>();
        courseRepository.findAll().forEach(target::add);
        return target;
    }
}
