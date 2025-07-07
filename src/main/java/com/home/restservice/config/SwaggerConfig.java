package com.home.restservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SwaggerConfig {
    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .servers(List.of(new Server().url("localhost:8080")))
                .info(new Info().title("Person's API"));
    }
}
