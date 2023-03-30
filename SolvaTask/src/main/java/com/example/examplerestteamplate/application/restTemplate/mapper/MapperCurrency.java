package com.example.examplerestteamplate.application.restTemplate.mapper;

import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDB;
import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDBRepository;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyDBDto;
import com.example.examplerestteamplate.application.restTemplate.model.UsdKzt;
import com.example.examplerestteamplate.application.restTemplate.model.UsdRub;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


@Component
@Slf4j
@RequiredArgsConstructor
public class MapperCurrency {

    private final CurrencyDBRepository currencyDBRepository;

    public CurrencyDBDto convertFromUsdKzt(UsdKzt dataWeather) {
        CurrencyDBDto currencyDto = new CurrencyDBDto();
        currencyDto.setDateTime(dataWeather.getUsdKztHuobi().getValues().get(0).getDatetime());
        currencyDto.setValue(dataWeather.getUsdKztHuobi().getValues().get(0).getClose());
        currencyDto.setType(dataWeather.getUsdKztHuobi().getMeta().getSymbol());
        return currencyDto;
    }

    public CurrencyDBDto convertFromUsdRub(UsdRub dataWeather) {
        CurrencyDBDto currencyDto = new CurrencyDBDto();
        currencyDto.setDateTime(dataWeather.getUsdRubHuobi().getValues().get(0).getDatetime());
        currencyDto.setValue(dataWeather.getUsdRubHuobi().getValues().get(0).getClose());
        currencyDto.setType(dataWeather.getUsdRubHuobi().getMeta().getSymbol());
        return currencyDto;
    }

    public CurrencyDB convertToCurrencyDB(CurrencyDBDto currencyDBDto) {
        CurrencyDB currencyDB = new CurrencyDB();
        if (!ObjectUtils.isEmpty(currencyDBRepository.getByType(currencyDBDto.getType()))) {
            currencyDB = currencyDBRepository.getByType(currencyDBDto.getType());
        }
        currencyDB.setDateTime(currencyDBDto.getDateTime());
        currencyDB.setType(currencyDBDto.getType());
        currencyDB.setValue(currencyDBDto.getValue());
        return currencyDB;
    }
}
