package com.enterprise.sandboxupgrade.entity;

public class PublicUser{
    public String name;
    public String username;

    public PublicUser(){
        name = "";
        username = "";
    }

    public PublicUser(Student student){
        name = student.getName();
        username = student.getUsername();
    }

    public PublicUser(Instructor instructor){
        name = instructor.getFullName();
        username = instructor.getUsername();
    }

@Override
public String toString() {
    return "Name: " + name + "; " + "Username: " + username;
}}
