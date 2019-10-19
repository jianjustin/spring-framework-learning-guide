package org.janine.jian;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Context;

@SpringBootApplication
@RestController
@EnableEncryptableProperties
public class SpringBootJasyptApp{
    @Autowired
    public  ApplicationContext appCtx;

    @RequestMapping("/")
    public String home(){
        return appCtx.getEnvironment().getProperty("spring.datasource.password");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .environment(new StandardEncryptableEnvironment())
                .sources(SpringBootJasyptApp.class)
                .run(args);
    }
}
