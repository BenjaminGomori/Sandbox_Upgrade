package com.enterprise.sandboxupgrade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cache.annotation.EnableCaching;

@Configuration
@EnableJpaRepositories
@EntityScan("com.enterprise.sandboxupgrade")
@SpringBootApplication
public class SandboxupgradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SandboxupgradeApplication.class, args);
    }

}
