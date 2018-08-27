package com.palagend.athena.athena.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger2
 * @author 顺其自然<palagend@gmail.com>
 * @date 2018-08-25 21:50:24
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket customDocket() {
        ParameterBuilder token = new ParameterBuilder();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("api swagger document")
                .description("前后端联调swagger api 文档")
                .version("1.0")
                .build();
    }

}
