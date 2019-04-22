package jumia.pay.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityRequest {
    private String email;
    private Date startDate;
    private Date endDate;
}
