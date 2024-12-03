package corporate.retailconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "corporate_transactions")
public class CorporateTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String storeId;

    @Column(nullable = false, unique = true)
    private String transactionId;

    private BigDecimal totalAmount;

    @Column(nullable = false)
    private Timestamp timestamp;

    private boolean synced;


}