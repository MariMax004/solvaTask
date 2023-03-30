package com.example.examplerestteamplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "currency")
//TODO Переименуй класс
public class CurrencyProperties {
    private String apiKey;

    private String url;

    private Long connectTimeout = 30000L;

    private Long readTimeout = 30000L;
}
