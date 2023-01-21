package com.enterprise.sandboxupgrade.dao;

import com.enterprise.sandboxupgrade.dto.Lab;

import java.util.List;

public interface ILabDAO {
    List<Lab> fetchAll() throws Exception;
}