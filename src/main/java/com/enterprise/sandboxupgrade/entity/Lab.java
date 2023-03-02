package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name = "labs")
public @Data
class Lab{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int labID;

    @Column(name = "number")
    public int number;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "link")
    public String link;

    @Column(name = "image")
    public String image;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "duedate")
    public Date dueDate;

    @ManyToOne
    @JoinColumn(name="courseID", nullable=false)
    @JsonBackReference
    public Course course;

}
