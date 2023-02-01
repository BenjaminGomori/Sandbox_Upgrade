package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.VM;

import java.util.List;

public interface IVmDAO {
    List<VM> fetchAll() throws Exception;
}

