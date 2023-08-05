package br.furb.restapifurb.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Serviço de uma lanchonete")
                        .description("Serviço de uma lanchonete para prova de suficiência da disciplina de Programação Web 2")
                        .version("1.0.0"));
    }
}
