package com.example.examplerestteamplate.application.transaction.web;

import com.example.examplerestteamplate.application.transaction.model.TransactionDto;
import com.example.examplerestteamplate.application.transaction.service.TransactionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Контроллер по работе с транзакциями")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/transactions")
    public TransactionDto addTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.addTransaction(transactionDto);
    }

    @GetMapping("/transactions")
    public List<TransactionDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/exceeded")
    public List<TransactionDto> getTransactionsExceeded() {
        return transactionService.getTransactionsExceeded();
    }

    @GetMapping(path="/test", produces = "application/json")
    public String getEmployees()
    {
        return "test";
    }
}
