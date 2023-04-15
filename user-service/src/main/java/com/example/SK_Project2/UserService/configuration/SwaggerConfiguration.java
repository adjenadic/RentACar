package com.example.SK_Project2.UserService.configuration;

import com.example.SK_Project2.UserService.controller.AdminController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {

//    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.any())
                .build();
    }

    private ApiInfo metaData() {
        return new ApiInfo("API", "API swagger definition", "1.0.0"
                , "Terms of service", new Contact("Vuk Adamovic", "", "vadamovic7621rn@raf.rs")
                , "", "", Collections.emptyList());
    }

}
