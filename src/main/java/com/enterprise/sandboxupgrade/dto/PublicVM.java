package com.enterprise.sandboxupgrade.dto;

public class PublicVM {
    // private int vmID;

    private String Name;
    private int VMWareNumber;
    private int PublicNumber;

    @Override
    public String toString() {
        return  "Name: "+this.Name  + "; VMWareNumber: " + this.VMWareNumber + "; PublicNumber: " +this.PublicNumber;
    }
}
