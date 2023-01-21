package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.VmConfigureOption;

import java.util.List;

public interface IVmConfigureOptionsDAO {
    List<VmConfigureOption> fetchAll() throws Exception;
}