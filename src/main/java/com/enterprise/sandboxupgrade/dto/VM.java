package com.enterprise.sandboxupgrade.dto;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "vms")
public @Data
class VM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vmID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "VMWarenumber")
    private int VMWareNumber;
//
    @Column(name = "Publicnumber")
    private int PublicNumber;

//    @Column(name = "osID")
//    private int osID;

//    @Column(name = "courseID ")
//    private String courseID;

//    @Column(name = "studentID")
//    private int studentID;
//
//    @Column(name = "instructorID")
//    private int instructorID;

    @ManyToOne
    @JoinColumn(name="courseID", nullable=false)
    private Course course;

    @Override
    public String toString() {
        return  "Name: "+this.Name  + "; VMWareNumber: " + this.VMWareNumber + "; PublicNumber: " +this.PublicNumber+"; Course: " + this.course;
    }
}
