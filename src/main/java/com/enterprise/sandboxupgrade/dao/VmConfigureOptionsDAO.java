package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.VmConfigureOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository("VmConfigureOptionsDAO")
@Profile({"dev", "default"})
public class VmConfigureOptionsDAO implements IVmConfigureOptionsDAO {

    @Autowired
    VmConfigureRepository vmConfigureRepository;

    @Override
    public Iterable<VmConfigureOption> fetchAll() {
//        List<VmConfigureOption> target = new ArrayList<>();
//        vmConfigureRepository.findAll().forEach(target::add);
        return vmConfigureRepository.findAll();
    }
}
