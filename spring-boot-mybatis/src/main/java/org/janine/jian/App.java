package org.janine.jian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("org.janine.jian")
public class App {

    @RequestMapping("/")
    public String home(){
        return "test H2 Database based Person Rest API";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
