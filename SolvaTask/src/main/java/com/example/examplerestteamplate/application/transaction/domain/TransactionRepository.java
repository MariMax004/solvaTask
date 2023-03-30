package com.example.examplerestteamplate.application.transaction.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAll();

    List<Transaction> findAllByLimitExceededTrue();
}
