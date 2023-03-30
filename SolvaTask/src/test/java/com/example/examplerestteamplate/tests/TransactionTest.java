package com.example.examplerestteamplate.tests;

import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.example.examplerestteamplate.application.transaction.model.TransactionDto;
import com.example.examplerestteamplate.application.transaction.service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TransactionTest {


    @Autowired
    private TransactionService transactionService;


    @Test
    public void testLimitExceed() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountFrom("123forTest");
        transactionDto.setSum(1000);
        transactionDto.setCurrencyShortname(CurrencyType.USD);
        Boolean bool = transactionService.addTransaction(transactionDto).isLimitExceeded();
        Assert.assertEquals(true, bool);
    }

}
