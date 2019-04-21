package jumia.pay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Temporal;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private boolean isSuccessful;
    private BigDecimal amount;
    private String creditCard;
    private String userEmail;
    private String trackingNumber;
    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdAt;
}
