package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ICourseDAO;
import com.enterprise.sandboxupgrade.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    ICourseDAO courseDAO;

    List<Course> courses;

    public CourseService(ICourseDAO courseDAO){
        this.courseDAO = courseDAO;
        this.courses = new ArrayList<Course>();
    }

    @Override
    public Course fetch(int id) {
        return courseDAO.fetch(id);
    }

    @Override
    public List<Course> fetchAll() throws Exception{
        if(courses.size() == 0){
            courses = courseDAO.fetchAll();
        }
        return courses;
    }
}