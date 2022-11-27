package com.enterprise.sandboxupgrade.dto;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "labs")
public @Data
class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int labID;

    @Column(name = "number")
    private int number;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name="courseID", nullable=false)
    private Course course;

    @Override
    public String toString() {
        return  "Number: "+this.number  + "; Desc: "+this.description  + ";  Course: " + this.course;
    }
}
