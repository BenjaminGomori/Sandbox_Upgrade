package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public @Data
class Instructor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int instructorID;

    @Column(name = "fullname")
    String fullName;

//    @Column(nullable = false, unique = true, length = 90, name = "email")
    @Column(name = "username")
    String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "instructor")
    private List<VM> vms;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "courseinstructor",
            joinColumns = @JoinColumn(name = "instructorID"),
            inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    private List<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "instructorrole",
            joinColumns = @JoinColumn(name = "instructorid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private List<Role> roles;

    @Override
    public String toString() {
        return "Name: " + fullName + " ;" + "Username: " + username;
    }
}
