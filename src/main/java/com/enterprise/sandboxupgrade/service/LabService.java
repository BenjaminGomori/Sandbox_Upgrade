package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ILabDAO;
import com.enterprise.sandboxupgrade.dto.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabService implements ILabService {

    @Autowired
    ILabDAO labDAO;

    public LabService(ILabDAO labDAO) {
        this.labDAO = labDAO;
    }

    @Override
    public Iterable<Lab> fetchAll() throws Exception {
        return labDAO.fetchAll();
    }
}