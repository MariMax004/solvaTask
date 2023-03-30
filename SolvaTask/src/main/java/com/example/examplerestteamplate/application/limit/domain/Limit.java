package com.example.examplerestteamplate.application.limit.domain;

import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.example.examplerestteamplate.application.transaction.domain.Transaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "client_limit")
@NoArgsConstructor
public class Limit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "limit_seq")
    @SequenceGenerator(name = "limit_seq", allocationSize = 1, sequenceName = "limit_seq")
    private Long id;

    @Column(name = "limit_sum")
    private Double limitSum;

    @Column(name = "limit_balance_product")
    private Double limitBalanceProduct;

    @Column(name = "limit_balance_service")
    private Double limitBalanceService;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "limit_datetime")
    private LocalDateTime limitDatetime;

    @Column(name = "limit_currency_shortname")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Column(name = "is_first_limit")
    private Boolean isFirstLimit;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "limit", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

}
