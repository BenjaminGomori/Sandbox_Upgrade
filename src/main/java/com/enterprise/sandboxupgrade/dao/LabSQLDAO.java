package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("labDAO")
@Profile({"dev", "default"})
public class LabSQLDAO implements ILabDAO {

    @Autowired
    LabRepository LabRepository;

    @Override
    public List<Lab> fetchAll() {
        List<Lab> target = new ArrayList<>();
        LabRepository.findAll().forEach(target::add);
        return target;
    }
}

