package com.example.similar_products.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfiguration {
    @Bean
    public RestTemplate httpClient() {
        return new RestTemplate();
    }
}
