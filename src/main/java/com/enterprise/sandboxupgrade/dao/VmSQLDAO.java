package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("vmDAO")
@Profile({"dev", "default"})
    public class VmSQLDAO implements IVmDAO {

    @Autowired
    VmRepository VmRepository;

    @Override
    public List<VM> fetchAll() {
        List<VM> target = new ArrayList<>();
        VmRepository.findAll().forEach(target::add);
        return target;

    }
}
