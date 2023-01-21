package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.VmConfigureOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("VmConfigureRepository")
public interface VmConfigureRepository extends CrudRepository<VmConfigureOption, Integer> {
}