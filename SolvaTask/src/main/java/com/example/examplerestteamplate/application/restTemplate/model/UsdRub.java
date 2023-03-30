package com.example.examplerestteamplate.application.restTemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsdRub {
    @JsonProperty("USD/RUB:Huobi")
    private DataCurrency usdRubHuobi;
}
