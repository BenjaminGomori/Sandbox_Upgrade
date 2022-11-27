package com.enterprise.sandboxupgrade.dto;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @Override public String toString() {
        return this.semester + this.courses;
    }
}
