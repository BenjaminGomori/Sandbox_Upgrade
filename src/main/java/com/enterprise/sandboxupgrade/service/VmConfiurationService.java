package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.IVmConfigureOptionsDAO;
import com.enterprise.sandboxupgrade.entity.VmConfigureOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class VmConfiurationService implements IVmConfigurationService {

    @Autowired
    IVmConfigureOptionsDAO VmConfigureOptionsDAO;
    Iterable<VmConfigureOption> vmConfigureOptions;

    public VmConfiurationService(IVmConfigureOptionsDAO VmConfigureOptionsDAO){
        this.VmConfigureOptionsDAO = VmConfigureOptionsDAO;
        vmConfigureOptions = new ArrayList<VmConfigureOption>();
    }

    @Override
    public Iterable<VmConfigureOption> fetchAll() throws Exception {
        if( StreamSupport.stream(vmConfigureOptions.spliterator(), false).count()==0);{
            vmConfigureOptions = this.VmConfigureOptionsDAO.fetchAll();
        }
        return vmConfigureOptions;
    }
}
