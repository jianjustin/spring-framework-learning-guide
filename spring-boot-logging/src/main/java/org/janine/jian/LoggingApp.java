package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@ComponentScan("org.janine.jian")
@Configuration
@RestController
public class LoggingApp {

    @RequestMapping("/")
    public String home(){
        return  "a guide about how to use logging with springboot project";
    }

    public static void main(String[] args) {
        SpringApplication.run(LoggingApp.class,args);
    }
}
