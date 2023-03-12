package com.enterprise.sandboxupgrade.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

public @Data
class PublicCourse {
    @Column(name = "id")
    public int id;
    @Column
    public String uniqueName;
    @Column
    public String name;
    @Column
    public String number;
    @Column
    public String section;
    @Column
    public String description;
    @Column
    public Year year;
    @Column
    public Semester semester;

    @Column
    //@OneToMany(mappedBy = "course")
    public List<PublicLab> publicLabs;

    @Column
    //@OneToMany(mappedBy = "course")
    public List<PublicVM> publicVms;

    @Column
    // this is for instructors to access students vms
    public Map<PublicUser,  List<PublicVM>> publicStudentVmsMap;

    @Override
    public String toString() {
        return this.number + " - " + this.name;
    }
}

