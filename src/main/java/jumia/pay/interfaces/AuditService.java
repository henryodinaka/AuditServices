package jumia.pay.interfaces;

import jumia.pay.enums.Actions;
import jumia.pay.enums.UserType;
import jumia.pay.model.Audit;
import org.springframework.data.domain.Page;

public interface AuditService {
    Page<Audit> getUserLog(String email);
    Page<Audit> getAllLog();
    void logActivity(Actions action, String userEmail, String json, UserType userType);
}
