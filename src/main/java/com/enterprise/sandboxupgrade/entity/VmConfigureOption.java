package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "vmconfigureoptions")
public @Data
class VmConfigureOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "configureoption")
    private String option;


//    private Map<Integer, String> options = new HashMap<>();
//
//
//    public Map<Integer, String> getVmConfigureOptions() {
//        return options;
//    }

}