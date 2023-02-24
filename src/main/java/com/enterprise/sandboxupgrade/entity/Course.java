package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public @Data
class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseID;

    @Column(name = "uniquename")
    private String uniqueName;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "section")
    private String section;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="yearID", nullable=false)
    @JsonBackReference
    private Year year;

    @ManyToOne
    @JoinColumn(name="semesterID", nullable=false)
    @JsonBackReference
    private Semester semester;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    @JsonManagedReference
    private List<VM> VMs;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    @JsonManagedReference
    private List<Lab> labs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "coursestudent",
            joinColumns = @JoinColumn(name = "courseID"),
            inverseJoinColumns = @JoinColumn(name = "studentID")
    )
    private List<Student> students;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "courseinstructor",
            joinColumns = @JoinColumn(name = "courseID"),
            inverseJoinColumns = @JoinColumn(name = "instructorID")
    )
    private List<Instructor> instructors;

    @Override
    public String toString() {
        return "";
    }
}