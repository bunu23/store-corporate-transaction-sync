package corporate.retailconnect.repository;

import corporate.retailconnect.model.CorporateTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorporateTransactionRepository extends JpaRepository<CorporateTransaction, Integer> {
}

