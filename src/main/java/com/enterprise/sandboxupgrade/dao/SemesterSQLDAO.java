package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository("SemesterDAO")
@Profile({"dev", "default"})
public class SemesterSQLDAO implements ISemesterDAO {

    @Autowired
    SemesterRepository SemesterRepository;

    @Override
    public Iterable<Semester> fetchAll() {
        return SemesterRepository.findAll();
    }
}


