package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dto.VmConfigureOption;

public interface IVmConfigurationService {
    Iterable<VmConfigureOption> fetchAll() throws Exception;
}
