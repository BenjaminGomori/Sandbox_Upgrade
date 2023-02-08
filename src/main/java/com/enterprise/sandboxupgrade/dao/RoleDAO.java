package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("roleDAO")
@Profile({"dev", "default"})
public class RoleDAO implements IRoleDAO {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> fetchAll() {
        List<Role> target = new ArrayList<>();
        roleRepository.findAll().forEach(target::add);
        return target;
    }
}
