package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.IInstructorDAO;
import com.enterprise.sandboxupgrade.dto.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService implements IInstructorService {

    @Autowired
    IInstructorDAO instructorDAO;

    List<Instructor> instructors;

    public InstructorService(IInstructorDAO instructorDAO){
        this.instructorDAO = instructorDAO;
        instructors = new ArrayList<Instructor>();
    }

    @Override
    public List<Instructor> fetchAll() throws Exception {
        if(instructors.size() == 0){
            instructors = instructorDAO.fetchAll();
        }
        return instructors;
    }
}

