package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.entity.VmConfigureOption;

public interface IVmConfigurationService {
    Iterable<VmConfigureOption> fetchAll() throws Exception;
}
