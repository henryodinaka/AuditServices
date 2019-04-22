package jumia.pay.dto;

import jumia.pay.enums.Actions;
import jumia.pay.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuditRequest {
    private Actions action;
    private String auditorEmail;
    private String json;
    private RoleName roleName;
}
