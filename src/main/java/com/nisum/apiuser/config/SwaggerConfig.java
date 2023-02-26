//package com.nisum.apiuser.config;
////
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Collections;
//
//
//@EnableSwagger2
//@EnableWebMvc
//public class SwaggerConfig {
//
//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.nisum.apiuser.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                //.apiInfo(getApiInfo())
//                ;
//    }
//
////    private ApiInfo getApiInfo() {
////        return new ApiInfo(
////                "User Service API",
////                "Nisum Api REST. Se expone una Api REST con un endpoint lo cual crea un usuario en la base de datos H2",
////                "1.0",
////                "",
////                new Contact("Cristian Leandro Botina Caipe", "", "cristian_botina@hotmail.com"),
////                "Open Source",
////                "",
////                Collections.emptyList()
////        );
////    }
//}
