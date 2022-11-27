package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.IVmDAO;

import com.enterprise.sandboxupgrade.dto.VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VmService implements IVmService {

    @Autowired
    IVmDAO vmDAO;

    public VmService(IVmDAO vmDAO) {
        this.vmDAO = vmDAO;
    }

    @Override
    public Iterable<VM> fetchAll() throws Exception {
        return vmDAO.fetchAll();
    }
}
