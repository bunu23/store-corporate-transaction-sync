package corporate.retailconnect.service;

import corporate.retailconnect.dto.CorporateTransactionDto;
import corporate.retailconnect.model.CorporateTransaction;
import corporate.retailconnect.repository.CorporateTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateTransactionService {
    @Autowired
    private CorporateTransactionRepository repository;

    public void saveTransaction(CorporateTransactionDto dto) {
        CorporateTransaction transaction = new CorporateTransaction();
        transaction.setStoreId(dto.getStoreId());
        transaction.setTransactionId(dto.getTransactionId());
        transaction.setTotalAmount(dto.getTotalAmount());
        transaction.setTimestamp(dto.getTimestamp());
        transaction.setSynced(true); // Mark as synced
        repository.save(transaction);
    }

    public List<CorporateTransaction> getAllTransactions() {
        return repository.findAll();
    }
}
