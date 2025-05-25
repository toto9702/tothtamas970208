package com.exam.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vizsga")
                        .version("1.0.0")
                        .description("Rest api végpontok")
                        .contact(new Contact()
                                .name("Tóth Tamás")
                                .email("toto9702@gmail.com")));
    }
}
