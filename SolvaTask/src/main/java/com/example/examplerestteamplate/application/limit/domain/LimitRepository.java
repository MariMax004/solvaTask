package com.example.examplerestteamplate.application.limit.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LimitRepository extends JpaRepository<Limit, Long> {

    @Query(value = "SELECT *FROM client_limit where bank_account = :account order by id desc limit 1", nativeQuery = true)
    Limit getLastLimit(@Param("account") String account);


    List<Limit> getByBankAccount(String account);
    Boolean existsByBankAccount(String account);

}
