package store.storehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import store.storehub.model.Transaction;
import store.storehub.service.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/transactions")
    public ResponseEntity<String> addTransaction(@RequestBody Transaction transaction) {
        try {
            transactionService.saveTransaction(transaction);
            return ResponseEntity.ok("Transaction saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving transaction!");
        }
    }
}
