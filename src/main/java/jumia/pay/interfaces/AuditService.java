package jumia.pay.interfaces;

import jumia.pay.dto.ActivityRequest;
import jumia.pay.model.Audit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface AuditService {
    Page<Audit> getUserLog(ActivityRequest request, Pageable pageable);
    Page<Audit> getAllLog(ActivityRequest request,Pageable pageable);
    Audit save(Audit audit);
}
