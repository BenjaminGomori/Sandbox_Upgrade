package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Lab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository("labDAO")
@Profile({"dev", "default"})
public class LabSQLDAO implements ILabDAO {

    @Autowired
    LabRepository LabRepository;

    @Override
    public Iterable<Lab> fetchAll() {
        return LabRepository.findAll();
    }
}

