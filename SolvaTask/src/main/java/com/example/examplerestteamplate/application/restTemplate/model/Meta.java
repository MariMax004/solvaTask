package com.example.examplerestteamplate.application.restTemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta {
    private String symbol;
    private String interval;
    @JsonProperty("currency_base")
    private String currencyBase;
    @JsonProperty("currency_quote")
    private String currencyQuote;
    private String type;

}
