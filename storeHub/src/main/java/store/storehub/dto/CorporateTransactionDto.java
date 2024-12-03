package store.storehub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class CorporateTransactionDto {
    private String storeId;
    private String transactionId;
    private BigDecimal totalAmount;
    private Timestamp timestamp;

}