package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.IVmConfigureOptionsDAO;
import com.enterprise.sandboxupgrade.entity.VmConfigureOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VmConfiurationService implements IVmConfigurationService {

    @Autowired
    IVmConfigureOptionsDAO VmConfigureOptionsDAO;
    List<VmConfigureOption> vmConfigureOptions;

    public VmConfiurationService(IVmConfigureOptionsDAO VmConfigureOptionsDAO){
        this.VmConfigureOptionsDAO = VmConfigureOptionsDAO;
        vmConfigureOptions = new ArrayList<VmConfigureOption>();
    }

    @Override
    public Iterable<VmConfigureOption> fetchAll() throws Exception {
        if(vmConfigureOptions.size() == 0){
            vmConfigureOptions = this.VmConfigureOptionsDAO.fetchAll();
        }
        return vmConfigureOptions;
    }
}
