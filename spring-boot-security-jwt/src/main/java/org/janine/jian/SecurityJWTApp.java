package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityJWTApp {
    @GetMapping("/")
    public String home(){
        return "a springboot app based h2 database and spring security oauth2";
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityJWTApp.class,args);
    }
}
