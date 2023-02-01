package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ISemesterDAO;
import com.enterprise.sandboxupgrade.entity.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SemesterService implements ISemesterService {

    @Autowired
    ISemesterDAO semesterDAO;

    List<Semester> semesters;

    public SemesterService(ISemesterDAO semesterDAO){
        this.semesterDAO = semesterDAO;
        semesters = new ArrayList<Semester>();
    }

    @Override
    public List<Semester> fetchAll() throws Exception {
        if(semesters.size() == 0){
            semesters = semesterDAO.fetchAll();
        }
        return semesters;
    }
}

