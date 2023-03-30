package com.example.examplerestteamplate.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Data
@Configuration
@RequiredArgsConstructor
//TODO Переименуй класс и все остальное про погоду
public class CurrencyRestTemplateConfiguration {
    private final CurrencyProperties weatherProperties;

    @Bean
    public RestTemplate weatherRestTemplate() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(Math.toIntExact(weatherProperties.getConnectTimeout()));
        clientHttpRequestFactory.setReadTimeout(Math.toIntExact(weatherProperties.getReadTimeout()));
        return new RestTemplate(clientHttpRequestFactory);
    }

}
