package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Instructor;

import java.util.List;

public interface IInstructorDAO {
    List<Instructor> fetchAll() throws Exception;
//    Instructor findByUsername(String username);
}
