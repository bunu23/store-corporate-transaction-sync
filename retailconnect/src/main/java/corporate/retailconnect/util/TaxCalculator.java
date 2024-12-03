package corporate.retailconnect.util;

import java.math.BigDecimal;

public class TaxCalculator {
    public static BigDecimal calculateTax(BigDecimal price,BigDecimal taxRate){
        return price.multiply(taxRate).divide(BigDecimal.valueOf(100));
    }
}
