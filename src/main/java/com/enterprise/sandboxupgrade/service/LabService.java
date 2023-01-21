package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ILabDAO;
import com.enterprise.sandboxupgrade.dto.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabService implements ILabService {

    @Autowired
    ILabDAO labDAO;

    List<Lab> labs;

    public LabService(ILabDAO labDAO){
        this.labDAO = labDAO;
        this.labs = new ArrayList<Lab>();
    }

    @Override
    public List<Lab> fetchAll() throws Exception {
        if(labs.size() == 0){
            this.labs = labDAO.fetchAll();
        }
        return labs;
    }
}