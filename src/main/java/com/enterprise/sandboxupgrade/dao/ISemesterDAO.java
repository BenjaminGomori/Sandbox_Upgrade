package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Semester;

import java.util.List;

public interface ISemesterDAO {
    List<Semester> fetchAll();
}