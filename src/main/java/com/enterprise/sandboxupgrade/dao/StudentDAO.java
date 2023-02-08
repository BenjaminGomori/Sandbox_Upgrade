package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentDAO")
@Profile({"dev", "default"})
public class StudentDAO implements IStudentDAO {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> fetchAll() {
        List<Student> target = new ArrayList<>();
        studentRepository.findAll().forEach(target::add);
        return target;
    }

//    @Override
//    public Student findByUsername(String username) {
//        Student stdudent = studentRepository.findByUsernamw(username);
//        return stdudent;
//    }
}

