package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.util.Date;

public @Data
 class PublicLab {
    @Column(name = "id")
    public int id;
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
    @Column(name = "course")
    @JsonBackReference
    public PublicCourse publicCourse;
    @Override
    public String toString() {
        return "Number: " + this.number + "; Desc: " + this.description;
    }
}
