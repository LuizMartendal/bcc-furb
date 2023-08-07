package br.furb.restapifurb.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String[] corsOriginPatterns = {"http://localhost:8080"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(corsOriginPatterns)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
}
