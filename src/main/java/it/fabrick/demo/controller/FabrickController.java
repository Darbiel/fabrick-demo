package it.fabrick.demo.controller;

import it.fabrick.demo.model.AccountTransactionsResponse;
import it.fabrick.demo.service.FabrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FabrickController {

    @Autowired
    FabrickService fabrickService;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity getCashAccountBalance(@PathVariable String accountId){
        try {
            return new ResponseEntity(fabrickService.getCashAccountBalance(accountId), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity getCashAccountTransactions(@PathVariable String accountId,
                                                     @RequestParam String fromAccountingDate,
                                                     @RequestParam String toAccountingDate){
        try {
            AccountTransactionsResponse cashAccountTransactions = fabrickService.getCashAccountTransactions(accountId, fromAccountingDate, toAccountingDate);
            return new ResponseEntity(cashAccountTransactions, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

    }

}
