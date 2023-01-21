package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Semester;

import java.util.List;

public interface ISemesterDAO {
    List<Semester> fetchAll();
}