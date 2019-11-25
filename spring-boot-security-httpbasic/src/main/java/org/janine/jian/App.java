package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableWebSecurity
@RestController
public class App {

    @GetMapping(value = "/")
    public String index(){
        return "a springboot project based spring security httpbasic";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
