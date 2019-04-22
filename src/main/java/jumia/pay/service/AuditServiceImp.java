package jumia.pay.service;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import jumia.pay.dto.AuditRequest;
import jumia.pay.interfaces.AuditService;
import jumia.pay.model.Audit;
import jumia.pay.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImp implements AuditService {
    @Autowired
    private AuditRepository auditRepository;


    public void logActivity(AuditRequest request) {
        Audit audit = null;
        if (request ==null) return;
        String json = request.getJson();
        DBObject dbObject= null;
        if (json == null) return;

        dbObject= jsonToDBObject(json);

        if (dbObject == null) return;

        audit = buildAuditObj(request,dbObject);

        if (audit != null)
            save(audit);
    }

    public Page<Audit> getUserLog(String auditorEmail) {
        return null;
    }

    public Page<Audit> getAllLog() {
        return null;
    }

    private void save(Audit audit)
    {
        auditRepository.save(audit);
    }
    protected DBObject jsonToDBObject(String json){
        DBObject dbObject = (DBObject) JSON
            .parse(json);
        return dbObject;
    }
    private Audit buildAuditObj(AuditRequest request, DBObject dbObject){
        Audit audit = new Audit();
        audit.setAction(request.getAction());
        audit.setTargetObject(dbObject);
        audit.setUserEmail(request.getAuditorEmail());
        audit.setRoleName(request.getRoleName());
        return audit;
    }
}
