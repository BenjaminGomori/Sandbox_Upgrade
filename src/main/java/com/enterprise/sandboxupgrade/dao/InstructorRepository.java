package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InstructorRepository")
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {
//    Instructor findByName(String username);
}
