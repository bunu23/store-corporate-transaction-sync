package store.storehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.storehub.dto.TransactionDto;
import store.storehub.model.Transaction;

import store.storehub.service.TransactionSyncService;

@RestController
@RequestMapping("/api/store")
public class TransactionSyncController {

    @Autowired
    private TransactionSyncService transactionSyncService;

    @PostMapping("/sync")
    public ResponseEntity<String> triggerSync() {
        transactionSyncService.syncTransactions();
        return ResponseEntity.ok("Sync process triggered!");
    }
}

//@RestController
//@RequestMapping("/transactions")
//public class TransactionController {
//
//    @Autowired
//    private TransactionService transactionService;
//
//    @PostMapping
//    public ResponseEntity<String> addTransaction(@RequestBody TransactionDto transactionDto) {
//        transactionService.addTransaction(transactionDto);
//        return ResponseEntity.ok("Transaction added successfully!");
//    }
//
//    @GetMapping("/{transactionId}")
//    public ResponseEntity<Transaction> getTransaction(@PathVariable String transactionId) {
//        Transaction transaction = transactionService.getTransactionById(transactionId);
//        return ResponseEntity.ok(transaction);
//    }
//}
