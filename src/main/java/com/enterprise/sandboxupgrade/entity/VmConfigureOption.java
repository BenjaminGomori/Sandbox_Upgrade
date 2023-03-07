package com.enterprise.sandboxupgrade.entity;

import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "vmconfigureoptions")
public @Data
class VmConfigureOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "number")
    public int number;

    @Column(name = "configureoption")
    public String option;


//    private Map<Integer, String> options = new HashMap<>();
//
//
//    public Map<Integer, String> getVmConfigureOptions() {
//        return options;
//    }

}
