package com.example.examplerestteamplate.application.restTemplate.service.impl;

import com.example.examplerestteamplate.application.common.Mapper;
import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDBRepository;

import com.example.examplerestteamplate.application.restTemplate.service.CurrencyService;
import com.example.examplerestteamplate.config.CurrencyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyProperties weatherProperties;
    private final Mapper mapper;
    private final CurrencyDBRepository currencyDBRepository;

    private final RestTemplate weatherRestTemplate;

//    @Override
//    public CurrencyDBDto getCurrency() {
//        String urlKzt = weatherProperties.getUrl()
//                .concat("?symbol=USD/KZT:Huobi,&interval=1h&apikey=")
//                .concat(weatherProperties.getApiKey());
//        String urlRub = weatherProperties.getUrl()
//                .concat("?symbol=USD/RUB:Huobi,&interval=1h&apikey=")
//                .concat(weatherProperties.getApiKey());
//        UsdKzt usdKzt = weatherRestTemplate.getForEntity(urlKzt, UsdKzt.class).getBody();
//        UsdRub usdRUB = weatherRestTemplate.getForEntity(urlRub, UsdRub.class).getBody();
//        if (usdKzt != null) {
//            currencyDBRepository.save(mapper.convertToCurrencyDB(convertTo(usdKzt)));
//            currencyDBRepository.save(mapper.convertToCurrencyDB(convertTo(usdRUB)));
//            return convertTo(usdRUB);
//        }
//        return null;
//    }
//
//    private CurrencyDBDto convertTo(UsdKzt dataWeather) {
//        CurrencyDBDto currencyDto = new CurrencyDBDto();
//        currencyDto.setDateTime(dataWeather.getUsdKztHuobi().getValues().get(0).getDatetime());
//        currencyDto.setValue(dataWeather.getUsdKztHuobi().getValues().get(0).getClose());
//        currencyDto.setType(dataWeather.getUsdKztHuobi().getMeta().getSymbol());
//        return currencyDto;
//    }
//
//    private CurrencyDBDto convertTo(UsdRub dataWeather) {
//        CurrencyDBDto currencyDto = new CurrencyDBDto();
//        currencyDto.setDateTime(dataWeather.getUsdRubHuobi().getValues().get(0).getDatetime());
//        currencyDto.setValue(dataWeather.getUsdRubHuobi().getValues().get(0).getClose());
//        currencyDto.setType(dataWeather.getUsdRubHuobi().getMeta().getSymbol());
//        return currencyDto;
//    }
}
