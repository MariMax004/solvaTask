package com.example.examplerestteamplate.utils;

import com.example.examplerestteamplate.application.restTemplate.domain.CurrencyDBRepository;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.example.examplerestteamplate.application.transaction.model.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionUtils {

    private final CurrencyDBRepository currencyDBRepository;

    public String getByTransactionCurrency(CurrencyType currency) {
        String newCurrency = CurrencyType.USD + "/" + currency;
        return newCurrency;
    }

    public Double getBalanceAfterTransaction(Double limitBalance, TransactionDto transactionDto) {
        if (transactionDto.getCurrencyShortname().equals(CurrencyType.USD))
            return limitBalance - transactionDto.getSum();
        else {
            Double currencyValue = currencyDBRepository.getByType(getByTransactionCurrency(transactionDto.getCurrencyShortname())).getValue();
            return limitBalance - transactionDto.getSum() / currencyValue;

        }
    }


}
