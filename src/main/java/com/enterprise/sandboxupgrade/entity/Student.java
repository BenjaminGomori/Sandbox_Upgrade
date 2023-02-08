package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public @Data
class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentID;

    @Column(name = "name")
    private String name;

    //    @Column(nullable = false, unique = true, length = 90, name = "email")
    //username = email -> security pck uses username field
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "student")
    private List<VM> vms;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "coursestudent",
            joinColumns = @JoinColumn(name = "studentID"),
            inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    private List<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "studentrole",
            joinColumns = @JoinColumn(name = "studentid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private List<Role> roles;

    @Override
    public String toString() {
        return "Name: " + name + " ;" + "username: " + username;
    }
}
