//from https://www.baeldung.com/spring-security-custom-logout-handler


//package com.enterprise.sandboxupgrade.config;
//
//import com.enterprise.sandboxupgrade.entity.Student;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//
//@Service
//public class UserCache {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private final ConcurrentMap<String, Student> store = new ConcurrentHashMap<>(256);
//
//    public Student getByUserName(String userName) {
//        return store.computeIfAbsent(userName, k ->
//                entityManager.createQuery("from User where login=:login", User.class)
//                        .setParameter("login", k)
//                        .getSingleResult());
//    }
//
//    public void evictUser(String userName) {
//        store.remove(userName);
//    }
//}
