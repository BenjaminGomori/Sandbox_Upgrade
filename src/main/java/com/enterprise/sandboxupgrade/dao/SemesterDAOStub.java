package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Semester;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("test")
public class SemesterDAOStub implements ISemesterDAO {

    Map<Integer, Semester> semesters = new HashMap<>();

    @Override
    public List<Semester> fetchAll() {
        return null;
    }
}

