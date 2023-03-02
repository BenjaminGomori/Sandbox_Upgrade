package com.enterprise.sandboxupgrade.entity;

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

    @Override
    public String toString() {
        return  "Name: "+this.name  + "; VMWareNumber: " + this.VMWareNumber + "; PublicNumber: " +this.publicNumber;
    }
}
