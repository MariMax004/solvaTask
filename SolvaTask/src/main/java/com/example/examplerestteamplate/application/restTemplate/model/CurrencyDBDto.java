package com.example.examplerestteamplate.application.restTemplate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrencyDBDto {
    @Schema(description = "Тип валюты")
    private String type;
    @Schema(description = "Дата и время скачивания данных валюты")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    @Schema(description = "Значение валюты")
    private double value;
}
