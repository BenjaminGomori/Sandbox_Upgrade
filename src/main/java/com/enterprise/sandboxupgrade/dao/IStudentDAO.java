package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> fetchAll() throws Exception;
}
