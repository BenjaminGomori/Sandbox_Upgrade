package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("SemesterDAO")
@Profile({"dev", "default"})
public class SemesterSQLDAO implements ISemesterDAO {

    @Autowired
    SemesterRepository semesterRepository;

    @Override
    public List<Semester> fetchAll() {
        List<Semester> target = new ArrayList<>();
        semesterRepository.findAll().forEach(target::add);
        return target;
    }
}


