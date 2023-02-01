package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public @Data
class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentID;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastName;

    //    @Column(nullable = false, unique = true, length = 90, name = "email")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "student")
    private List<VM> vms;

    @ManyToMany
    @JoinTable(
            name = "coursestudent",
            joinColumns = @JoinColumn(name = "studentID"),
            inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    private List<Course> courses;

    @Override
    public String toString() {
        return "Firstname: " + firstname +"Lastname: " + lastName + " ;" + "Email: " + email;
    }
}
