package com.enterprise.sandboxupgrade.dto;

import lombok.Data;
import javax.persistence.*;

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
