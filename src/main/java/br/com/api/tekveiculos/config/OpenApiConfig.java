package br.com.api.tekveiculos.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI tekVeiculos() {
        return new OpenAPI()
                .info(new Info().title("Tek-Veículos API")
                        .description("Projeto desenvolvido para o gerencimento de veículos da Tek-System.")
                        .version("v0.1")
                        .license(new License().name("Tek-Veículos").url("https://github.com/offteuz"))
                );
    }
}
