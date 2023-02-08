
package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> fetchAll() throws Exception;
}