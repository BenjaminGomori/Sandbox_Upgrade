package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dto.Lab;

public interface ILabService {
    Iterable<Lab> fetchAll() throws Exception;
}
