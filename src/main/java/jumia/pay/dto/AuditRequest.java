package jumia.pay.dto;

import jumia.pay.enums.Actions;
import jumia.pay.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequest {
    private Actions action;
    private String auditorEmail;
    private String json;
    private UserType userType;
}
