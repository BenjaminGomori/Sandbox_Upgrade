package com.enterprise.sandboxupgrade.dao;
import com.enterprise.sandboxupgrade.dto.Lab;
import com.enterprise.sandboxupgrade.dto.VM;

public interface ILabDAO {
    Iterable<Lab> fetchAll() throws Exception;
}