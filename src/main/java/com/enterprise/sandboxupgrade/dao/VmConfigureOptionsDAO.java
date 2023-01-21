package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Semester;
import com.enterprise.sandboxupgrade.dto.VmConfigureOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("VmConfigureOptionsDAO")
@Profile({"dev", "default"})
public class VmConfigureOptionsDAO implements IVmConfigureOptionsDAO {

    @Autowired
    VmConfigureRepository VmConfigureRepository;

    @Override
    public List<VmConfigureOption> fetchAll() {
        List<VmConfigureOption> target = new ArrayList<>();
        VmConfigureRepository.findAll().forEach(target::add);
        return target;
    }
}
