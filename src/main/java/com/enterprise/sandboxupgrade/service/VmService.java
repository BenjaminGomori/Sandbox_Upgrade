package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.IVmDAO;
import com.enterprise.sandboxupgrade.dto.VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VmService implements IVmService {

    @Autowired
    IVmDAO vmDAO;

    List<VM> vms;

    public VmService(IVmDAO vmDAO){
        this.vmDAO = vmDAO;
        vms = new ArrayList<VM>();
    }

    @Override
    public Iterable<VM> fetchAll() throws Exception {
        if(vms.size() == 0){
            vms = vmDAO.fetchAll();
        }
        return vms;
    }
}
