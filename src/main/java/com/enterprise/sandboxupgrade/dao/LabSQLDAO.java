package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("labDAO")
@Profile({"dev", "default"})
public class LabSQLDAO implements ILabDAO {

    @Autowired
    LabRepository labRepository;

    int newLabtId = 1;

    @Override
    public List<Lab> fetchAll() {
        List<Lab> target = new ArrayList<>();
        labRepository.findAll().forEach(target::add);
        return target;
    }

    @Override
    public Lab save(Lab lab) throws Exception {
        labRepository.save(lab);
        return labRepository.save(lab);
    }
}

