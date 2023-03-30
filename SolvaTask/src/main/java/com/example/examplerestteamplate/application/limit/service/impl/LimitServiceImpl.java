package com.example.examplerestteamplate.application.limit.service.impl;

import com.example.examplerestteamplate.application.common.Mapper;
import com.example.examplerestteamplate.application.limit.domain.Limit;
import com.example.examplerestteamplate.application.limit.domain.LimitRepository;
import com.example.examplerestteamplate.application.limit.model.LimitDto;
import com.example.examplerestteamplate.application.limit.service.LimitService;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.example.examplerestteamplate.errors.ErrorDescriptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class LimitServiceImpl implements LimitService {
    private final Mapper mapper;
    private final LimitRepository limitRepository;

    @Override
    public List<LimitDto> getClientLimits(String bankAccount) {
        ErrorDescriptor.NOT_BANK_ACCOUNT.throwIsFalse(limitRepository.existsByBankAccount(bankAccount));
        return limitRepository.getByBankAccount(bankAccount)
                .stream().map(mapper::convertToLimitDto)
                .sorted((Comparator.comparingLong(LimitDto::getId)))
                .collect(Collectors.toList());
    }


    @Override
    public LimitDto updateLimit(LimitDto limitDto) {
        ErrorDescriptor.NO_BANK_ACCOUNT.throwIsTrue(ObjectUtils.isEmpty(limitDto.getBankAccount()));
        ErrorDescriptor.NO_SUM.throwIsTrue(ObjectUtils.isEmpty(limitDto.getLimitSum()));
        ErrorDescriptor.NOT_BANK_ACCOUNT.throwIsFalse(limitRepository.existsByBankAccount(limitDto.getBankAccount()));
        Limit limit = limitRepository.getLastLimit(limitDto.getBankAccount());
        ErrorDescriptor.NOT_FIRST_LIMIT.throwIsFalse(limit.getIsFirstLimit());
        Limit newLimit = mapper.convertToLimit(limitDto, limit);
        limitRepository.save(newLimit);
        return mapper.convertToLimitDto(newLimit);
    }
    public Limit createNewLimit(String bankAccount) {
        Limit limit = new Limit();
        limit.setLimitDatetime(LocalDateTime.now());
        limit.setLimitSum(1000D);
        limit.setCurrency(CurrencyType.USD);
        limit.setBankAccount(bankAccount);
        limit.setIsFirstLimit(true);
        limit.setLimitBalanceProduct(1000D);
        limit.setLimitBalanceService(1000D);
        return limit;
    }
}
