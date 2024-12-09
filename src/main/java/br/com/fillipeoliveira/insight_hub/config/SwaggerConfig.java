package br.com.fillipeoliveira.insight_hub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  
  private String title = "Insight_Hub API";
  private String description = "API responsável pela gestão de avaliações dos usuários a produtos postados por empresas";
  private String version = "1.0";

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(
          new Info()
              .title(title)
              .description(description)
              .version(version)
        );
  }  
}
