package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.dao.ILabDAO;
import com.enterprise.sandboxupgrade.dao.IRoleDAO;
import com.enterprise.sandboxupgrade.entity.Lab;
import com.enterprise.sandboxupgrade.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    IRoleDAO roleDAO;

    List<Role> roles;

    public RoleService(IRoleDAO roleDAO){
        this.roleDAO = roleDAO;
        this.roles = new ArrayList<Role>();
    }

    @Override
    public List<Role> fetchAll() throws Exception {
        if(roles.size() == 0){
            roles = roleDAO.fetchAll();
        }
        return roles;
    }
}
