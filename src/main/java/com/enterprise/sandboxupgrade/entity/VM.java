package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "vms")
public @Data
class VM extends PublicVM{
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

    @ManyToOne
    @JoinColumn(name="courseID", nullable=false)
    private Course course;

    @ManyToOne
    @JoinColumn(name="studentID", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="instructorID", nullable=false)
    private Instructor instructor;

    @Override
    public String toString() {
        return "";
    }
}
