package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Role;
import java.util.List;

public interface IRoleDAO {
    List<Role> fetchAll() throws Exception;
}
