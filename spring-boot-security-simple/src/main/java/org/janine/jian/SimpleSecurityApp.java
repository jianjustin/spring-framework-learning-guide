package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SimpleSecurityApp {

    @RequestMapping("/")
    public String root() {
        return "a simple spring boot project with spring security";
    }


    public static void main(String[] args) {
        SpringApplication.run(SimpleSecurityApp.class,args);
    }
}
