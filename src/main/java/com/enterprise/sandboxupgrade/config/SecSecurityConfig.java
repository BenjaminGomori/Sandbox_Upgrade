package com.enterprise.sandboxupgrade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

// (https://spring.io/guides/gs/securing-web/)
//https://www.baeldung.com/spring-security-login

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        SimpleUrlAuthenticationSuccessHandler authSuccessHandler = new SimpleUrlAuthenticationSuccessHandler();
//        authSuccessHandler.setUseReferer(true);
//        authSuccessHandler.setDefaultTargetUrl("/index.html");

        http.csrf()
                .disable()
                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/resources/**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/photos/**").permitAll()
                        .requestMatchers("/images/**").permitAll()
                        .requestMatchers("/videos/**").permitAll()
                        .requestMatchers("/powerStartVM","/powerOffVM","/getConsoleTicket").permitAll()
//                    .requestMatchers("/","/index","/index.html").permitAll()
                        .requestMatchers("/","/index","/index.html").hasAnyAuthority("STUDENT","INSTRUCTOR")
                        .requestMatchers("/createLab").hasAuthority("INSTRUCTOR")
//                        .requestMatchers("/saveLab").hasAuthority("instructor")
//                        .requestMatchers("/**", "index", "/create-lab","saveLab").hasRole("STUDENT")
//                        .anyRequest().authenticated()
                )
                .formLogin((form) -> {
                            try {
                                form
                                        .loginPage("/login")
                                        .permitAll()
                                        .loginProcessingUrl("/login")
                                        .defaultSuccessUrl("/", true)
//                                        .successHandler(authSuccessHandler)
                                        .failureUrl("/login?error=true")
                                        .and()
                                        .logout()
                                        .logoutSuccessUrl("/login.html")
//                                        .logoutUrl("/perform_logout")
                                        .deleteCookies("JSESSIONID");


//                                        .failureHandler(authenticationFailureHandler()
//                                        .and()
//                                        .logout()
//                                        .logoutUrl("/perform_logout")
//                                        .deleteCookies("JSESSIONID")
//                                        .logoutSuccessHandler(logoutSuccessHandler()
//                                        );

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
//                .logout((logout) -> logout.permitAll());

        http
                .headers()
                .frameOptions()
                .sameOrigin();

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    //TODO this is the first one i aws using
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new CustomAuthenticationFailureHandler();
//    }

//    @Override
//    protected void AuthenticationFailureHandler(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
}