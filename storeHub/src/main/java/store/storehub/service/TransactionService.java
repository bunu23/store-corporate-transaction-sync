package store.storehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.storehub.dto.TransactionDto;
import store.storehub.exception.TransactionNotFoundException;
import store.storehub.model.Transaction;
import store.storehub.repository.TransactionRepository;

import java.sql.Timestamp;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

}
