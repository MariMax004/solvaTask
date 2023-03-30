package com.example.examplerestteamplate.application.restTemplate.domain;


import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyDBRepository extends JpaRepository<CurrencyDB, Long> {

    CurrencyDB getByType(String type);

}
