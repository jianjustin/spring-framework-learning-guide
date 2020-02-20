package org.janine.jian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SecurityJWTApp {
    @GetMapping("/")
    public String home(){
        return "redirect:swagger-ui.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityJWTApp.class,args);
    }
}
