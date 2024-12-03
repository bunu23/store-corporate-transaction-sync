package store.storehub.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionDto {
    private String transactionId;
    private BigDecimal totalAmount;

}
