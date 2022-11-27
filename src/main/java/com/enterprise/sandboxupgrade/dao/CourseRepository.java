package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CourseRepository")
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
