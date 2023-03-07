package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.VmConfigureOption;

import java.util.List;

public interface IVmConfigureOptionsDAO {
    Iterable<VmConfigureOption> fetchAll() throws Exception;
}