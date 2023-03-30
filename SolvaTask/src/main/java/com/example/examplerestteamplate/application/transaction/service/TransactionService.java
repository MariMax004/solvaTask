package com.example.examplerestteamplate.application.transaction.service;

import com.example.examplerestteamplate.application.transaction.model.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto addTransaction(TransactionDto transactionDto);

    List<TransactionDto> getAllTransactions();

    List<TransactionDto> getTransactionsExceeded();
    String testString ();
}
