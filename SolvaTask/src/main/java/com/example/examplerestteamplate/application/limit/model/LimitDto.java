package com.example.examplerestteamplate.application.limit.model;


import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LimitDto {
    @Schema(description = "Идентификатор лимита")
    private Long id;

    @Schema(description = "Сумма лимита")
    private Double limitSum;
    @Schema(description = "Остаток по лимиту категории Продукт")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double limitBalanceProduct;

    @Schema(description = "Остаток по лимиту категории Сервис")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double limitBalanceService;
    @Schema(description = "Дата и время установление лимита")
    private LocalDateTime limitDatetime;
    @Schema(description = "Валюта лимита")
    private CurrencyType currency;

    @Schema(description = "Переменная для проверки установления нового лимита")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isFirstLimit;

    @Schema(description = "Банковский аккаунт")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bankAccount;

}
