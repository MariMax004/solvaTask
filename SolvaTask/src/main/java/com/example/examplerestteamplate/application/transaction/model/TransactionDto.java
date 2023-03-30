package com.example.examplerestteamplate.application.transaction.model;

import com.example.examplerestteamplate.application.limit.model.LimitDto;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {
    @Schema(description = "Идентификатор транзакции")
    private Long id;
    @Schema(description = "Счет отправитель")
    private String accountFrom;
    @Schema(description = "Счет получатель")
    private String accountTo;
    @Schema(description = "Сумма")
    private double sum;
    @Schema(description = "Валюта")
    private CurrencyType currencyShortname;
    @Schema(description = "Категория расхода")
    private ExpenseType expenseCategory;
    @Schema(description = "Дата и время транзакции")
    private LocalDateTime dateTime;

    @Schema(description = "Переменная для проверки превышения лимита")
    private boolean limitExceeded;
    @Schema(description = "Лимит")
    private LimitDto limit;



}
