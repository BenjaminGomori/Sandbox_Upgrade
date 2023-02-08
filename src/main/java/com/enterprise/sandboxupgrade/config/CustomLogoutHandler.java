//from https://www.baeldung.com/spring-security-custom-logout-handler

//package com.enterprise.sandboxupgrade.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserCache;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomLogoutHandler implements LogoutHandler {
//
//    private final UserCache userCache;
//
//    public CustomLogoutHandler(UserCache userCache) {
//        this.userCache = userCache;
//    }
//
//    @Override
//    public void logout(HttpServletRequest request, HttpServletResponse response,
//                       Authentication authentication) {
//        String userName = UserUtils.getAuthenticatedUserName();
//        userCache.evictUser(userName);
//    }
//}
