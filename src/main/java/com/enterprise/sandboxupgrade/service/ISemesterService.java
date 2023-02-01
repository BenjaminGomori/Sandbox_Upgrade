package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.entity.Semester;

public interface ISemesterService {
    Iterable<Semester> fetchAll() throws Exception;
}

