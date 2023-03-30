package com.example.examplerestteamplate.application.restTemplate.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@lombok.Data
public class Values {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datetime;
    private double open;
    private double high;
    private double low;
    private double close;
}
