package com.enterprise.sandboxupgrade.dto;

import javax.persistence.Column;
import java.util.List;

public class PublicCourse {
    @Column
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

//    @Override
    public String toString() {
        return this.number + " - " + this.name;
    }
}

