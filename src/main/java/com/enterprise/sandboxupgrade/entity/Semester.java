package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Semesters")
public @Data
class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int semesterID;

    @Column(name = "semester")
    private String semester;

    @OneToMany(mappedBy = "semester")
    private List<Course> courses;

    @Override
    public String toString() {
        return "";
    }
}
