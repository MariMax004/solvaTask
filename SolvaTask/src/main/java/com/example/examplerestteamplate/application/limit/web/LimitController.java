package com.example.examplerestteamplate.application.limit.web;

import com.example.examplerestteamplate.application.limit.model.LimitDto;
import com.example.examplerestteamplate.application.limit.service.LimitService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Контроллер по работе с лимитами")
public class LimitController {
    private final LimitService limitService;


    @PutMapping("/limits")
    public LimitDto updateLimit(@RequestBody LimitDto limitDto) {
        return limitService.updateLimit(limitDto);
    }

    @GetMapping("/limits")
    public List<LimitDto> getClientLimits(@RequestParam String bankAccount) {
        return limitService.getClientLimits(bankAccount);
    }


}
