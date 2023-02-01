package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.VM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("VmRepository")
public interface VmRepository extends CrudRepository<VM, Integer> {
}