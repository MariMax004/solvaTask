package com.example.examplerestteamplate.application.common;


import com.example.examplerestteamplate.application.limit.domain.Limit;
import com.example.examplerestteamplate.application.limit.domain.LimitRepository;
import com.example.examplerestteamplate.application.limit.model.LimitDto;
import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDB;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.example.examplerestteamplate.application.transaction.domain.Transaction;
import com.example.examplerestteamplate.application.transaction.model.TransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class Mapper {
    private final LimitRepository limitRepository;

    public Transaction convertToTransaction(TransactionDto transactionDto, Limit limit) {
        Transaction transaction = new Transaction();
        transaction.setCurrencyShortname(transactionDto.getCurrencyShortname());
        transaction.setSum(transactionDto.getSum());
        transaction.setAccountFrom(transactionDto.getAccountFrom());
        transaction.setAccountTo(transactionDto.getAccountTo());
        transaction.setDateTime(LocalDateTime.now());
        transaction.setExpenseCategory(transactionDto.getExpenseCategory());
        transaction.setLimit(limit);
        if (limit.getLimitBalanceProduct() < 0 || limit.getLimitBalanceService() < 0)
            transaction.setLimitExceeded(true);
        else transaction.setLimitExceeded(false);
        return transaction;
    }

    public TransactionDto convertToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setCurrencyShortname(transaction.getCurrencyShortname());
        transactionDto.setSum(transaction.getSum());
        transactionDto.setAccountFrom(transaction.getAccountFrom());
        transactionDto.setAccountTo(transaction.getAccountTo());
        transactionDto.setDateTime(transaction.getDateTime());
        transactionDto.setLimitExceeded(transaction.isLimitExceeded());
        transactionDto.setExpenseCategory(transaction.getExpenseCategory());
        transactionDto.setLimit(convertToLimitDto(transaction.getLimit()));
        return transactionDto;
    }



    public LimitDto convertToLimitDto(Limit limit) {
        LimitDto limitDto = new LimitDto();
        limitDto.setId(limit.getId());
        limitDto.setLimitDatetime(limit.getLimitDatetime());
        limitDto.setLimitSum(limit.getLimitSum());
        limitDto.setCurrency(limit.getCurrency());
        return limitDto;
    }

    public Limit convertToLimit(LimitDto limitDto, Limit lasLimit) {
        Limit limit = new Limit();
        limit.setLimitDatetime(LocalDateTime.now());
        limit.setLimitSum(limitDto.getLimitSum());
        limit.setCurrency(CurrencyType.USD);
        limit.setBankAccount(limitDto.getBankAccount());
        limit.setIsFirstLimit(false);
        limit.setLimitBalanceProduct(limitDto.getLimitSum() - lasLimit.getLimitSum() + lasLimit.getLimitBalanceProduct());
        limit.setLimitBalanceService(limitDto.getLimitSum() - lasLimit.getLimitSum() + lasLimit.getLimitBalanceService());
        return limit;
    }



}
