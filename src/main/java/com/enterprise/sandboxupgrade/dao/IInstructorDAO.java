package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Instructor;

import java.util.List;

public interface IInstructorDAO {
    List<Instructor> fetchAll() throws Exception;
}
