package com.enterprise.sandboxupgrade.dto;

import javax.persistence.Column;

public class PublicUser{
    public String firstname;
    public String lastName;
    public String email;

@Override
public String toString() {
    return "Firstname: " + firstname +"Lastname: " + lastName + " ;" + "Email: " + email;
}}
