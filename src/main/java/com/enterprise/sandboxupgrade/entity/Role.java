package com.enterprise.sandboxupgrade.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "roles")
public @Data
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleid;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "studentrole",
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns = @JoinColumn(name = "studentid")
    )
    private List<Student> students;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "instructorrole",
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns = @JoinColumn(name = "instructorid")
    )
    private List<Instructor> instructors;
}