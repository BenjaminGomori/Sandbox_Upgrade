package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.VM;

public interface IVmDAO {
    Iterable<VM> fetchAll() throws Exception;
}

