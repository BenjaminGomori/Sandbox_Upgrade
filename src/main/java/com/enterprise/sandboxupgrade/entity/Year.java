package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "years")
public @Data
class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int yearID;

    @Column(name = "year")
    private int number;

    @OneToMany(mappedBy = "year")
    private List<Course> courses;

    @Override
    public String toString() {
        return "";
    }
}
