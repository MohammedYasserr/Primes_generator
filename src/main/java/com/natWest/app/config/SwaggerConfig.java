package com.natWest.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket primeNumberGeneratorApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api.*"))
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    private springfox.documentation.service.ApiInfo apiInfo() {
        return new springfox.documentation.service.ApiInfo(
                "API",
                "Prime Number Gen",
                "1.0/",
                "Sample Code",
                "Sample Code",
                "",
                "");
    }

}
