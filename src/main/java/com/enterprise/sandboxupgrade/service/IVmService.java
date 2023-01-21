package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dto.VM;

import java.util.Map;

public interface IVmService {
    Iterable<VM> fetchAll() throws Exception;
}
