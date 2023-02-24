package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.entity.Instructor;
import com.enterprise.sandboxupgrade.entity.Student;

import java.util.List;

public interface IInstructorService {
    List<Instructor> fetchAll() throws Exception;
}