package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository("vmDAO")
@Profile({"dev", "default"})
    public class VmSQLDAO implements IVmDAO {

    @Autowired
    VmRepository VmRepository;

    @Override
    public Iterable<VM> fetchAll() {
        return VmRepository.findAll();
    }
}
