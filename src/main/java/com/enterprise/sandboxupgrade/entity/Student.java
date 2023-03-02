package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "students")
public @Data
class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int studentID;

    @Column(name = "name")
    public String name;

    //    @Column(nullable = false, unique = true, length = 90, name = "email")
    //username = email -> security pck uses username field
    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    public List<VM> vms;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "coursestudent",
            joinColumns = @JoinColumn(name = "studentID"),
            inverseJoinColumns = @JoinColumn(name = "courseID")
    )
    public List<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "studentrole",
            joinColumns = @JoinColumn(name = "studentid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    public List<Role> roles;

    @Override
    public String toString() {
        return "Name: " + name + " ;" + "username: " + username;
    }
}
