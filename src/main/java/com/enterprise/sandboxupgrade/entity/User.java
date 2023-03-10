package com.enterprise.sandboxupgrade.entity;

import jakarta.persistence.Column;

public class User {
    @Column
    public int id;
    @Column
    public String email;
    @Column
    public String name;
    @Column
    public String type;
}
