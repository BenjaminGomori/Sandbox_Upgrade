package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.entity.VM;

public interface IVmService {
    Iterable<VM> fetchAll() throws Exception;
}
