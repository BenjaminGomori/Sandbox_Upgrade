package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dto.VM;

public interface IVmService {
    Iterable<VM> fetchAll() throws Exception;
}
