package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityJWTApp {
    @RequestMapping("/")
    public String home(){
        return " a Rest API based SpringBoot and Spring Security OAuth2";
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityJWTApp.class,args);
    }
}
