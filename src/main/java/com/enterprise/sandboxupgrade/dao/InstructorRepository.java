package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InstructorRepository")
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

}
