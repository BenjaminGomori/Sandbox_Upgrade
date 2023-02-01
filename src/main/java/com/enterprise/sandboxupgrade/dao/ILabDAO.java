package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.entity.Lab;

import java.util.List;

public interface ILabDAO {
    List<Lab> fetchAll() throws Exception;
    Lab save(Lab lab) throws Exception;
}