package com.example.examplerestteamplate.application.limit.service;

import com.example.examplerestteamplate.application.limit.domain.Limit;
import com.example.examplerestteamplate.application.limit.model.LimitDto;

import java.util.List;

public interface LimitService {
    List<LimitDto> getClientLimits(String bankAccount);

    LimitDto updateLimit(LimitDto limitDto);
    Limit createNewLimit(String bankAccount);
}
