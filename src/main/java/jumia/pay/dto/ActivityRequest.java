package jumia.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ActivityRequest {
    private String email;
    private Date startDate;
    private Date endDate;
}
