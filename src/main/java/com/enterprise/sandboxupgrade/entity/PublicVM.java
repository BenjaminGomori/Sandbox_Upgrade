package com.enterprise.sandboxupgrade.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

public class PublicVM {
    @Column
    public int vmID;
    @Column
    public String name;
    @Column
    public int VMWareNumber;
    @Column
    public int publicNumber;
    @Column
    public String VMWareName;
    @Column
    @JsonBackReference
    public Student student;
    @Column
    @JsonBackReference
    public Instructor instructor;
    @Column
    public int studentId;
    @Column
    public int instructorId;
    @Column
    public String username;
    @Column
    public String email;

    @Override
    public String toString() {
        return  "Name: "+this.name  + "; VMWareNumber: " + this.VMWareNumber + "; PublicNumber: " +this.publicNumber;
    }
}
