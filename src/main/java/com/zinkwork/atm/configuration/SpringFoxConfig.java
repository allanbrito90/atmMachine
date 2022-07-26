package com.zinkwork.atm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SpringFoxConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("All APIs")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zinkwork.atm.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ATM Machine API")
                .version("1.0.0")
                .contact(new Contact(
                        "Allan Brito",
                        "https://allanbrito.netlify.app/",
                        "allan.brito@outlook.com.br"))
                .build();
    }
}