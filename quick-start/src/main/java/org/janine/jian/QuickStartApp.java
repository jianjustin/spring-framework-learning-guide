package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan("org.janine.jian")
@Configuration
public class QuickStartApp {

    @RequestMapping("/")
    public String home(){
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(QuickStartApp.class,args);
    }
}
