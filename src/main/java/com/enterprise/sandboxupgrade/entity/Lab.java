package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "labs")
public @Data
class Lab{
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "duedate")
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name="courseID", nullable=false)
    private Course course;

}
