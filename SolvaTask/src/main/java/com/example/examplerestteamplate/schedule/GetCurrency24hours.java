package com.example.examplerestteamplate.schedule;

import com.example.examplerestteamplate.application.restTemplate.mapper.MapperCurrency;
import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDB;
import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDBRepository;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyDBDto;
import com.example.examplerestteamplate.application.restTemplate.model.UsdKzt;
import com.example.examplerestteamplate.application.restTemplate.model.UsdRub;
import com.example.examplerestteamplate.config.CurrencyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;


@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class GetCurrency24hours {

    private final CurrencyDBRepository currencyDBRepository;

    private final CurrencyProperties weatherProperties;

    private final RestTemplate weatherRestTemplate;
    private final MapperCurrency mapperCurrency;

    @Scheduled(cron = "0 0 8 * * ?")
    @PostConstruct
    private void initCurrencyKzt() {
        log.info("currency Kzt {}", LocalDateTime.now());
        String urlKzt = weatherProperties.getUrl()
                .concat("?symbol=USD/KZT:Huobi,&interval=1h&apikey=")
                .concat(weatherProperties.getApiKey());
        UsdKzt usdKzt = weatherRestTemplate.getForEntity(urlKzt, UsdKzt.class).getBody();
        if (usdKzt != null) {
            CurrencyDBDto currencyDBDto = mapperCurrency.convertFromUsdKzt(usdKzt);
            CurrencyDB currencyDBKZT = mapperCurrency.convertToCurrencyDB(currencyDBDto);
            currencyDBRepository.save(currencyDBKZT);
        }
    }

    @PostConstruct
    @Scheduled(cron = "0 0 8 * * ?")
    private void initCurrencyRub() {
        log.info("currency Rub {}", LocalDateTime.now());
        String urlRub = weatherProperties.getUrl()
                .concat("?symbol=USD/RUB:Huobi,&interval=1h&apikey=")
                .concat(weatherProperties.getApiKey());
        UsdRub usdRUB = weatherRestTemplate.getForEntity(urlRub, UsdRub.class).getBody();
        if (usdRUB != null) {
            CurrencyDBDto currencyDBDto = mapperCurrency.convertFromUsdRub(usdRUB);
            CurrencyDB currencyDBRUB = mapperCurrency.convertToCurrencyDB(currencyDBDto);
            currencyDBRepository.save(currencyDBRUB);
        }
    }

}
