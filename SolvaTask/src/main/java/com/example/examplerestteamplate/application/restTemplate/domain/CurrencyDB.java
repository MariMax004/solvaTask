package com.example.examplerestteamplate.application.restTemplate.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "currency")
public class CurrencyDB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_seq")
    @SequenceGenerator(name = "currency_seq", allocationSize = 1, sequenceName = "currency_seq")
    private Long id;

    @Column(name = "currency_type")
    private String type;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "value_currency")
    private double value;

}