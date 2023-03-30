package com.example.examplerestteamplate.tests;


import com.example.examplerestteamplate.ExampleRestTemplateApplication;
import com.example.examplerestteamplate.application.restTemplate.model.CurrencyType;
import com.example.examplerestteamplate.application.transaction.model.TransactionDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;


@SpringBootTest(classes = ExampleRestTemplateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {
    @Autowired
    public TestRestTemplate testRestTemplate;
//
//    @Test
//    public void testAddTransaction() {
//        TransactionDto transactionDto = new TransactionDto();
//        transactionDto.setAccountFrom("123forTest");
//        transactionDto.setSum(1000);
//        transactionDto.setCurrencyShortname(CurrencyType.USD);
//        ResponseEntity<String> responseEntity = this.testRestTemplate
//                .postForEntity("http://localhost:" + 8081 + "/transactions", transactionDto, String.class);
//        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
//
//    }
//
//    @Test
//    public void testGetAllTransactions() {
//        ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity("http://localhost:" + 8081 + "/transactions", String.class);
//        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void testBankAccountExist() {
//        TransactionDto transactionDto = new TransactionDto();
//        transactionDto.setSum(1000);
//        transactionDto.setCurrencyShortname(CurrencyType.USD);
//        ResponseEntity<String> responseEntity = this.testRestTemplate
//                .postForEntity("http://localhost:" + 8081 + "/transactions", transactionDto, String.class);
//        Assert.assertEquals(400, responseEntity.getStatusCodeValue());
//        Assert.assertTrue(responseEntity.getBody().contains("Банк аккаунт не введен или введен неверно"));
//
//    }
//
//    @Test
//    public void testGetLimitByBankAcccount() {
//        String account = "123forTest";
//        ResponseEntity<String> responseEntity = this.testRestTemplate
//                .getForEntity("http://localhost:" + 8081 + "/limits?bankAccount=" + account, String.class);
//        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
//
//    }

}
