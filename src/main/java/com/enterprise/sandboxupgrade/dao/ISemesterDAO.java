package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Semester;

public interface ISemesterDAO {
    Iterable<Semester> fetchAll();
}