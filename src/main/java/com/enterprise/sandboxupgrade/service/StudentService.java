package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.IStudentDAO;
import com.enterprise.sandboxupgrade.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    List<Student> students;

    public StudentService(IStudentDAO studentDAO){
        this.studentDAO = studentDAO;
        students = new ArrayList<Student>();
    }

    @Override
    public List<Student> fetchAll() throws Exception {
        if(students.size() == 0){
            students = studentDAO.fetchAll();
        }
        return students;
    }
}

