package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("instructorDAO")
@Profile({"dev", "default"})
public class InstructorDAO implements IInstructorDAO {

    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public List<Instructor> fetchAll() {
        List<Instructor> target = new ArrayList<>();
        instructorRepository.findAll().forEach(target::add);
        return target;
    }
}


