package org.janine.jian;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@SpringBootApplication
@RestController
public class DataSourceApp {


    @RequestMapping("/")
    public String home(){
        return "the way to config custom datasource";
    }

    public static void main(String[] args) {
        SpringApplication.run(DataSourceApp.class,args);
    }

    //@Bean
    //@ConfigurationProperties("app.datasource")
    //public DataSource dataSource(){
        //return DataSourceBuilder.create().build();
    //    return DataSourceBuilder.create().type(HikariDataSource.class).build();
    //}

}
