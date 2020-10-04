package com.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author halle
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("POST", "OPTIONS", "GET", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true).maxAge(3600);
    }
}
