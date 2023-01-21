package com.enterprise.sandboxupgrade.dto;

import lombok.Data;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public @Data
class Instructor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int instructorID;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "instructor")
    private List<VM> vms;

    @ManyToMany
    @JoinTable(
            name = "courseinstructor",
            joinColumns = @JoinColumn(name = "instructorID"),
            inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    private List<Course> courses;

    @Override
    public String toString() {
        return "Firstname: " + firstname +"Lastname: " + lastName + " ;" + "Email: " + email;
    }
}
