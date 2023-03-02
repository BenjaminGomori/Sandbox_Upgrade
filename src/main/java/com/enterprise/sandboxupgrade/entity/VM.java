package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "vms")
public @Data
class VM extends PublicVM{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int vmID;

    @Column(name = "Name")
    public String Name;

    @Column(name = "VMWarenumber")
    public int VMWareNumber;
//
    @Column(name = "Publicnumber")
    public int PublicNumber;

    @Column(name = "VMWrename")
    public String VMWareName;

//    @Column(name = "osID")
//    private int osID;

    @ManyToOne
    @JoinColumn(name="courseID", nullable=false)
    @JsonBackReference
    public Course course;

    @ManyToOne
    @JoinColumn(name="studentID", nullable=false)
    @JsonBackReference
    public Student student;

    @ManyToOne
    @JoinColumn(name="instructorID", nullable=false)
    @JsonBackReference
    public Instructor instructor;

    @Override
    public String toString() {
        return "";
    }
}
