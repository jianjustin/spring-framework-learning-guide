package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class QuickStartApp {

    @RequestMapping("/")
    public String home(){
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(QuickStartApp.class,args);
    }
}
