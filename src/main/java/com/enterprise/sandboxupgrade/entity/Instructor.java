package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "instructors")
public @Data
class Instructor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int instructorID;

    @Column(name = "fullname")
    public String fullName;

//    @Column(nullable = false, unique = true, length = 90, name = "email")
    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instructor")
    @JsonManagedReference
    public List<VM> vms;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "courseinstructor",
            joinColumns = @JoinColumn(name = "instructorID"),
            inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    public List<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "instructorrole",
            joinColumns = @JoinColumn(name = "instructorid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    public List<Role> roles;

    @Override
    public String toString() {
        return "Name: " + fullName + " ;" + "Username: " + username;
    }
}
