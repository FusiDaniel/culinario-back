package com.culinario.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info().title("Culinario"));
    }

    @Bean
    public GroupedOpenApi allEndpoints() {
        return GroupedOpenApi.builder()
                .group("1. All resources")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi usersEndpoints() {
        return GroupedOpenApi.builder()
                .group("2. Users")
                .pathsToMatch("/users/**")
                .build();
    }

    @Bean
    public GroupedOpenApi dishesEndpoints() {
        return GroupedOpenApi.builder()
                .group("3. Dishes")
                .pathsToMatch("/dishes/**")
                .build();
    }

    @Bean
    public GroupedOpenApi ingredientsEndpoints() {
        return GroupedOpenApi.builder()
                .group("4. Ingredients")
                .pathsToMatch("/ingredients/**")
                .build();
    }

}
