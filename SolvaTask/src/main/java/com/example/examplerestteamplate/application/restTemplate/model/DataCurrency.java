package com.example.examplerestteamplate.application.restTemplate.model;

import java.util.List;

@lombok.Data
public class DataCurrency {
    private Meta meta;
    private List<Values> values;
    private String status;
}
