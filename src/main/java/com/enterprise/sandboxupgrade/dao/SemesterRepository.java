package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Course;
import com.enterprise.sandboxupgrade.dto.Semester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("SemesterRepository")
public interface SemesterRepository extends CrudRepository<Semester, Integer> {

}