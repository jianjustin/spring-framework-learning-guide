package org.janine.jian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.janine.jian.controller"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("auth", "用户认证"))
                .tags(new Tag("authority", "授权模块"))
                .tags(new Tag("role", "角色模块"))
                .tags(new Tag("user", "用户模块"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基于JWT的RESTful API")
                .build();
    }

}
