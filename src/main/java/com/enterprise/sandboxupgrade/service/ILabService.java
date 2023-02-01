package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.entity.Lab;

import java.util.List;

public interface ILabService {
    List<Lab> fetchAll() throws Exception;
    Lab save(Lab lab) throws Exception;
}
