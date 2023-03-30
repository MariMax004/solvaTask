package com.example.examplerestteamplate.application.restTemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsdKzt {
    @JsonProperty("USD/KZT:Huobi")
    private DataCurrency usdKztHuobi;
}
