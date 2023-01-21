package com.enterprise.sandboxupgrade.dto;

import javax.persistence.Column;

public class PublicLab {
    @Column
    public int number;
    @Column
    public String title;
    @Column
    public String description;
    @Column
    public String link;
    @Column
    public String image;

    @Override
    public String toString() {
        return "Number: " + this.number + "; Desc: " + this.description;
    }
}
