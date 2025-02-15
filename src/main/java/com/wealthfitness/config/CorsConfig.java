package com.wealthfitness.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
public class CorsConfig {

    @Bean  // it define CORS spring boot
    //WebMvcConfigurer use for customizing Spring MVC for crossmapping
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {  
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // it use for API route allow CROS
                        .allowedOrigins("http://localhost:3000")  // frontend port link
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // allows this HTTP methods
                        .allowedHeaders("*")  // use to allow all headers and request from front end
                        .allowCredentials(true);  // it use send cookies for JWT
            }
        };
    }
}
