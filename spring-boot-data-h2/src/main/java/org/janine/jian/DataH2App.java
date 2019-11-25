package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DataH2App {

    @RequestMapping("/")
    public String home(){
        return "test H2 Database based Person Rest API";
    }

    public static void main(String[] args) {
        SpringApplication.run(DataH2App.class,args);
    }
}
