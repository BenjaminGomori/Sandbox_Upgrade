package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "roles")
public @Data
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int roleid;

    @Column(name = "name")
    public String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "studentrole",
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns = @JoinColumn(name = "studentid")
    )
    public List<Student> students;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "instructorrole",
            joinColumns = @JoinColumn(name = "roleid"),
            inverseJoinColumns = @JoinColumn(name = "instructorid")
    )
    public List<Instructor> instructors;
}