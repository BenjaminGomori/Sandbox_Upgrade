package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ISemesterDAO;
import com.enterprise.sandboxupgrade.dto.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService implements ISemesterService {


    @Autowired
    ISemesterDAO semesterDAO;

    public SemesterService(ISemesterDAO semesterDAO) {
        this.semesterDAO = semesterDAO;
    }

    @Override
    public Iterable<Semester> fetchAll() throws Exception {
        return semesterDAO.fetchAll();
    }
}

