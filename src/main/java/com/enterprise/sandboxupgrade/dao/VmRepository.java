package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.VM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("VmRepository")
public interface VmRepository extends CrudRepository<VM, Integer> {

}