package com.example.examplerestteamplate.application.transaction.service.impl;

import com.example.examplerestteamplate.application.common.Mapper;
import com.example.examplerestteamplate.application.limit.domain.Limit;
import com.example.examplerestteamplate.application.limit.domain.LimitRepository;
import com.example.examplerestteamplate.application.limit.service.LimitService;
import com.example.examplerestteamplate.application.transaction.domain.Transaction;
import com.example.examplerestteamplate.application.transaction.domain.TransactionRepository;
import com.example.examplerestteamplate.application.transaction.model.TransactionDto;
import com.example.examplerestteamplate.application.transaction.service.TransactionService;
import com.example.examplerestteamplate.errors.ErrorDescriptor;
import com.example.examplerestteamplate.utils.TransactionUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final Mapper mapper;
    private final LimitRepository limitRepository;
    private final TransactionUtils transactionUtils;
    private final LimitService limitService;

    @Override
    @Transactional
    public TransactionDto addTransaction(TransactionDto transactionDto) {
        ErrorDescriptor.NO_BANK_ACCOUNT.throwIsTrue(ObjectUtils.isEmpty(transactionDto.getAccountFrom()));
        ErrorDescriptor.NO_SUM.throwIsTrue(ObjectUtils.isEmpty(transactionDto.getSum()));
        ErrorDescriptor.NO_CURRENCY.throwIsTrue(ObjectUtils.isEmpty(transactionDto.getCurrencyShortname()));
        Limit limit;
        if (!limitRepository.existsByBankAccount(transactionDto.getAccountFrom())) {
            limit = limitService.createNewLimit(transactionDto.getAccountFrom());
            limitRepository.save(limit);
        } else {
            limit = limitRepository.getLastLimit(transactionDto.getAccountFrom());
        }
        switch (transactionDto.getExpenseCategory()) {
            case SERVICE -> limit.setLimitBalanceService(transactionUtils.getBalanceAfterTransaction(limit.getLimitBalanceService(), transactionDto));
            case PRODUCT -> limit.setLimitBalanceProduct(transactionUtils.getBalanceAfterTransaction(limit.getLimitBalanceProduct(), transactionDto));
        }

        Transaction transaction = mapper.convertToTransaction(transactionDto, limit);
        transactionRepository.save(transaction);
        return mapper.convertToTransactionDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll().stream().map(mapper::convertToTransactionDto)
                .sorted(Comparator.comparingLong(TransactionDto::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDto> getTransactionsExceeded() {
        return transactionRepository.findAllByLimitExceededTrue().stream().map(mapper::convertToTransactionDto)
                .sorted((Comparator.comparingLong(TransactionDto::getId)))
                .collect(Collectors.toList());
    }

    @Override
    public String testString() {
        return "test";
    }
}
