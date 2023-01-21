package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.VM;

import java.util.List;

public interface IVmDAO {
    List<VM> fetchAll() throws Exception;
}

