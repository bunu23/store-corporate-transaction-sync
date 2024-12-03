package corporate.retailconnect.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class CorporateTransactionDto {

        private String storeId;
        private String transactionId;
        private BigDecimal totalAmount;
        private Timestamp timestamp;


    }

