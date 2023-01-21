package com.enterprise.sandboxupgrade.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public @Data
class Course extends PublicCourse {
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
    private Year year;

    @ManyToOne
    @JoinColumn(name="semesterID", nullable=false)
    private Semester semester;

    @OneToMany(mappedBy = "course")
    private List<VM> VMs;

    @OneToMany(mappedBy = "course")
    private List<Lab> labs;

    @ManyToMany
    @JoinTable(
            name = "coursestudent",
            joinColumns = @JoinColumn(name = "courseID"),
            inverseJoinColumns = @JoinColumn(name = "studentID")
    )
    private List<Student> students;

    @ManyToMany
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