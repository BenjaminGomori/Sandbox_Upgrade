package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dto.Semester;


public interface ISemesterService {
    Iterable<Semester> fetchAll() throws Exception;
}

