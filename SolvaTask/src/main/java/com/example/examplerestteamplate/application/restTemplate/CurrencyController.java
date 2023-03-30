package com.example.examplerestteamplate.application.restTemplate;

import com.example.examplerestteamplate.application.restTemplate.model.CurrencyDBDto;
import com.example.examplerestteamplate.application.restTemplate.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService testService;
//
//    @GetMapping("/exchange")
//    public CurrencyDBDto getCurrency() {
//
//        return testService.getCurrency();
//    }
}
