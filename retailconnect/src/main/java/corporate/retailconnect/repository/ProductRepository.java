package corporate.retailconnect.repository;

import corporate.retailconnect.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
Optional<Product> findBySku(String sku);
}
