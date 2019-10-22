package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class SimpleSecurityApp {

    @RequestMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String index() {
        return "home";
    }

    @RequestMapping("/hello")
    public String userIndex() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleSecurityApp.class,args);
    }
}
