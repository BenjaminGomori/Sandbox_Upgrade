package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.Course;

public interface ICourseService {

    Course fetch(int courseID);

    Iterable<Course> fetchAll() throws Exception;

//    List<LabelValue> generateEventsSearchableData() throws Exception;

}