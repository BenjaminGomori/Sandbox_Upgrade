package com.enterprise.sandboxupgrade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class SandboxupgradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SandboxupgradeApplication.class, args);
    }

}
