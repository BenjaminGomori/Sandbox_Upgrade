package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Instructor;
import com.enterprise.sandboxupgrade.entity.Student;

import java.util.List;

public interface IStudentDAO {
    List<Student> fetchAll() throws Exception;
//    Student findByUsername(String username);
}
