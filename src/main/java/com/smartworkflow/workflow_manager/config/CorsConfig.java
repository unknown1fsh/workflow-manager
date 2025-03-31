package com.smartworkflow.workflow_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Frontend uygulamasının URL'i
        config.addAllowedOrigin("http://localhost:4200");

        // İzin verilen HTTP metodları
        config.addAllowedMethod("*");

        // İzin verilen header'lar
        config.addAllowedHeader("*");

        // Kimlik bilgilerinin (credentials) gönderilmesine izin ver
        config.setAllowCredentials(true);

        // Tüm endpoint'ler için CORS yapılandırmasını uygula
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}