package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "years")
public @Data
class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int yearID;

    @Column(name = "year")
    public int number;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "year")
    @JsonManagedReference
    public List<Course> courses;

    @Override
    public String toString() {
        return "";
    }
}
