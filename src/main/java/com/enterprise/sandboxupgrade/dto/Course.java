package com.enterprise.sandboxupgrade.dto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public @Data
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "section")
    private String section;


    @Column(name = "description")
    private String description;

    @Column(name = "yearID")
    private String year;

    @ManyToOne
    @JoinColumn(name="semesterID", nullable=false)
    private Semester semester;

    @OneToMany(mappedBy = "course")
    private List<VM> VMs;

    @OneToMany(mappedBy = "course")
    private List<Lab> labs;


    @Override public String toString() {
        return this.name +' '+ this.number + this.section;
    }
}