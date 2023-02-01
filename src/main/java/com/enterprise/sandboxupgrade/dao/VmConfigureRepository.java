package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.VmConfigureOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("VmConfigureRepository")
public interface VmConfigureRepository extends CrudRepository<VmConfigureOption, Integer> {
}