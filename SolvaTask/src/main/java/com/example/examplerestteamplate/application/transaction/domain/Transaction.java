package com.example.examplerestteamplate.application.transaction.domain;

import com.example.examplerestteamplate.application.limit.domain.Limit;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.examplerestteamplate.application.transaction.model.ExpenseType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction")
    @SequenceGenerator(name = "transaction", allocationSize = 1, sequenceName = "transaction_seq")
    private Long id;

    @Column(name = "account_from")
    private String accountFrom;
    @Column(name = "account_to")
    private String  accountTo;
    @Column(name = "sum")
    private double sum;

    @Column(name = "currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyShortname;
    @Column(name = "expense_category")
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseCategory;
    @Column(name = "datetime")
    private LocalDateTime dateTime;
    @Column(name = "limit_exceed")
    private boolean limitExceeded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "limit_id")
    private Limit limit;



}