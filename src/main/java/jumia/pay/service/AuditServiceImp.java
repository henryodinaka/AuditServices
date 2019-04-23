package jumia.pay.service;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import jumia.pay.dto.ActivityRequest;
import jumia.pay.dto.AuditRequest;
import jumia.pay.interfaces.AuditService;
import jumia.pay.model.Audit;
import jumia.pay.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImp implements AuditService {
    @Autowired
    private AuditRepository auditRepository;

    /**
     * Persists user activities to DB
     * @param request
     */
    public void logActivity(AuditRequest request) {
        Audit audit = buildAuditObj(request);

        if (audit != null)
            save(audit);
    }

    /**
     * Get user logs
     * @param request
     * @param pageable
     * @return
     */
    public Page<Audit> getUserLog(ActivityRequest request, Pageable pageable) {
        if (request == null)return null; ;
        auditRepository.findUserActivitieBetween(request.getEmail(),request.getStartDate(),request.getEndDate(),pageable);
        return null;
    }

    /**
     * Get all logs
     * @param request
     * @param pageable
     * @return
     */
    public Page<Audit> getAllLog(ActivityRequest request,Pageable pageable) {
        auditRepository.findActivitieBetween(request.getStartDate(),request.getEndDate(),pageable);
        return null;
    }

    public Audit save(Audit audit)
    {
        return auditRepository.save(audit);
    }

    /**
     * Covert json to DBObject
     * @param json
     * @return
     */
    protected DBObject jsonToDBObject(String json){
        DBObject dbObject = (DBObject) JSON
            .parse(json);
        return dbObject;
    }

    /**
     * Generate audit object to be saved
     * @param request
     * @return
     */
    private Audit buildAuditObj(AuditRequest request){
        Audit audit = new Audit();
        audit.setAction(request.getAction());
        audit.setTargetObject(request.getJson());
        audit.setUserEmail(request.getAuditorEmail());
        audit.setRoleName(request.getRoleName());
        return audit;
    }
}
