package com.enterprise.sandboxupgrade.service;

import com.enterprise.sandboxupgrade.entity.Instructor;
import com.enterprise.sandboxupgrade.entity.Role;
import com.enterprise.sandboxupgrade.entity.Student;
import com.enterprise.sandboxupgrade.dao.StudentRepository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IOrchestratorService orchestratorService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = orchestratorService.findStudentByUsername(username);
        Instructor instructor = orchestratorService.findInstructorByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if(student != null){
            for (Role role : student.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getPassword(), grantedAuthorities);
        } else if(instructor != null){
            for (Role role : instructor.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(instructor.getUsername(), instructor.getPassword(), grantedAuthorities);
        }

        //todo what is the proper way to handle a non-unthicate user here?
        return new org.springframework.security.core.userdetails.User("", "", grantedAuthorities);
    }
}