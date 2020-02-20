package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableWebSecurity
@SpringBootApplication
public class SimpleSecurityApp {

    @GetMapping("/")
    public String root() {
        return "a simple spring boot project with spring security";
    }


    public static void main(String[] args) {
        SpringApplication.run(SimpleSecurityApp.class,args);
    }
}
