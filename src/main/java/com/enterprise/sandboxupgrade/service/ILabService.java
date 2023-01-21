package com.enterprise.sandboxupgrade.service;
import com.enterprise.sandboxupgrade.dto.Lab;

import java.util.List;

public interface ILabService {
    List<Lab> fetchAll() throws Exception;
}
