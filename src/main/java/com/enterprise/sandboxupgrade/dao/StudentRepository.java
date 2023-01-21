package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("StudentRepository")
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
