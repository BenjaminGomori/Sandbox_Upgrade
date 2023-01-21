package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.Student;

import java.util.List;

public interface IStudentService {
    List<Student> fetchAll() throws Exception;
}