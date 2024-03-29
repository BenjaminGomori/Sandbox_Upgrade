package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Lab;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("LabRepository")
public interface LabRepository extends CrudRepository<Lab, Integer> {

}