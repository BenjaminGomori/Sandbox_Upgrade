package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ICourseDAO;
import com.enterprise.sandboxupgrade.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {


    @Autowired
    ICourseDAO courseDAO;

    public CourseService(ICourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public Course fetch(int id) {
        return courseDAO.fetch(id);
    }

    @Override
    public Iterable<Course> fetchAll() throws Exception {
        return courseDAO.fetchAll();
    }

//    @Override
//    public List<LabelValue> generateEventsSearchableData() throws Exception {
//        List<LabelValue> eventsSearchableData = new LinkedList<>();
//        for (Course event : fetchAll()) {
//            LabelValue labelValue = new LabelValue();
//            labelValue.setValue(event.getId());
//            labelValue.setLabel(event.getName() + ", " + event.getDescription());
//            eventsSearchableData.add(labelValue);
//        }
//        return eventsSearchableData;
//    }
//
//    @Override
//    public List<Course> searchEvents(String searchText) throws Exception {
//        List<Course> eventList = new LinkedList<>();
//        for (Course event : fetchAll()) {
//            if (event.getName().contains(searchText) || event.getDescription().contains(searchText)) {
//                eventList.add(event);
//            }
//        }
//        return eventList;
//    }
}