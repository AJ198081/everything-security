package dev.aj.ssl1ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SsL1Ex1Application {

    public static void main(String[] args) {
        SpringApplication.run(SsL1Ex1Application.class, args);
    }

}
