package com.test.jiao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createSpringRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)
                .apis(RequestHandlerSelectors.basePackage("com.test.jiao.controller"))//
                .paths(PathSelectors.any())
                .build();//创建
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建API")
                .description("更多点击:https://swagger.io/")
                .termsOfServiceUrl("https://swagger.io/")
                .version("1.0")
                .build();
    }
}