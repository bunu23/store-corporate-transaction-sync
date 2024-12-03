package corporate.retailconnect.controller;

import corporate.retailconnect.dto.CorporateTransactionDto;
import corporate.retailconnect.model.CorporateTransaction;
import corporate.retailconnect.service.CorporateTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class CorporateTransactionController {
    @Autowired
    private CorporateTransactionService transactionService;


//    @PostMapping
//    public ResponseEntity<String> addTransaction(@RequestBody CorporateTransactionDto dto) {
//        transactionService.saveTransaction(dto);
//        return ResponseEntity.ok("Transaction received and saved!");
//    }
    @PostMapping
    public ResponseEntity<String> addTransaction(@RequestBody CorporateTransactionDto dto) {
        try {
            transactionService.saveTransaction(dto);
            return ResponseEntity.ok("Transaction received and saved!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate transaction ID!");
        }
    }

    // GET method to fetch all transactions
    @GetMapping
    public ResponseEntity<List<CorporateTransaction>> getAllTransactions() {
        List<CorporateTransaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

}
