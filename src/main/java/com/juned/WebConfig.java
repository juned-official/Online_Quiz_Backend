package com.juned;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // **IMPORTANT: Replace this with your actual GitHub Pages URL**
        String allowedOrigin = "https://juned-official.github.io"; 
        
        registry.addMapping("/**") // Apply to all endpoints in your application
                .allowedOrigins(allowedOrigin,"http://localhost:4200") // Allow requests ONLY from your GitHub Pages URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify the HTTP methods you use
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow sending cookies/authorization headers
    }
}
