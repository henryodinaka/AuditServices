package jumia.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String customerEmail;
    private String creditCard;
    private BigDecimal amount;
    private String trackingNumber;
}
