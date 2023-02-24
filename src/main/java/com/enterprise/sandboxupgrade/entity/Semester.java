package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Semesters")
public @Data
class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int semesterID;

    @Column(name = "semester")
    public String semester;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "semester")
    @JsonManagedReference
    public List<Course> courses;

    @Override
    public String toString() {
        return "";
    }
}
