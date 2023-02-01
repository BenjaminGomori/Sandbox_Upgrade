package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> fetchAll() throws Exception;
}