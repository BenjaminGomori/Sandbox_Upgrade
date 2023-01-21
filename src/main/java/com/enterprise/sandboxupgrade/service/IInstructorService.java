package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.Instructor;

import java.util.List;

public interface IInstructorService {
    List<Instructor> fetchAll() throws Exception;
}