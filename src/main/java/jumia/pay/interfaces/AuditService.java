package jumia.pay.interfaces;

import jumia.pay.model.Audit;
import org.springframework.data.domain.Page;

public interface AuditService {
    Page<Audit> getUserLog(String email);
    Page<Audit> getAllLog();
}
