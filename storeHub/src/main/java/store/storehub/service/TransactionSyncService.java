package store.storehub.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import store.storehub.dto.CorporateTransactionDto;

import store.storehub.model.Transaction;
import store.storehub.repository.TransactionRepository;

import java.util.List;
@Service
public class TransactionSyncService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @Value("${corporate.api.transactions}")
    @Value("${corporate.api.transactions}")
    private String corporateTransactionsApi;

    @Value("${store.id}")
    private String storeId;
    public List<Transaction> getUnsyncedTransactions() {
        return transactionRepository.findBySyncedFalse();
    }

    @Transactional
    public void syncTransactions() {
        List<Transaction> unsyncedTransactions = getUnsyncedTransactions();

        for (Transaction transaction : unsyncedTransactions) {
            try {
                // Map transaction to DTO
                CorporateTransactionDto dto = new CorporateTransactionDto(
                        storeId, // Assuming a fixed store ID
                        transaction.getTransactionId(),
                        transaction.getTotalAmount(),
                        transaction.getTimestamp()
                );

                // Send to Corporate API
                ResponseEntity<String> response = restTemplate.postForEntity(corporateTransactionsApi, dto, String.class);

                if (response.getStatusCode().is2xxSuccessful()) {
                    // Mark transaction as synced
                    transaction.setSynced(true);
                    transactionRepository.save(transaction);
                }
            } catch (HttpClientErrorException | HttpServerErrorException e) {
                System.err.println("Failed to sync transaction: " + transaction.getTransactionId() + ", Reason: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error syncing transaction: " + transaction.getTransactionId());
            }
        }
    }
}
