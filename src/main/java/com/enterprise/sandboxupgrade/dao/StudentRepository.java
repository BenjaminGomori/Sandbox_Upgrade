package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("StudentRepository")
public interface StudentRepository extends CrudRepository<Student, Integer> {
//    Student findByUsernamw(String username);
}
