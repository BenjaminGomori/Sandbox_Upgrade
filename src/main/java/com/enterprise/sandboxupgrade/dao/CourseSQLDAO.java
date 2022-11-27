package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository("courseDAO")
@Profile({"dev", "default"})
public class CourseSQLDAO implements ICourseDAO {


    @Autowired
    CourseRepository CourseRepository;

    @Override
    public Course fetch(int eventId) {
        return CourseRepository.findById(eventId).get();
    }

    @Override
    public Iterable<Course> fetchAll() {
        return CourseRepository.findAll();
    }
}
