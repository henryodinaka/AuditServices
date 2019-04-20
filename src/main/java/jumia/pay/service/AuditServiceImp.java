package jumia.pay.service;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import jumia.pay.enums.Actions;
import jumia.pay.enums.UserType;
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

    @Override
    public void logActivity(Actions action, String userEmail,String json,UserType userType) {
        Audit audit = null;
        DBObject dbObject= null;
        if (json == null) return;

        dbObject= jsonToDBObject(json);

        if (dbObject == null) return;

        audit = buildAuditObj(action,dbObject,userEmail,userType);

        if (audit != null)
            save(audit);
    }

    @Override
    public Page<Audit> getUserLog(String email) {
        return null;
    }

    @Override
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
    private Audit buildAuditObj(Actions actions, DBObject dbObject, String userEmail, UserType userType){
        Audit audit = new Audit();
        audit.setAction(actions);
        audit.setTargetObject(dbObject);
        audit.setUserEmail(userEmail);
        audit.setUserType(userType);
        return audit;
    }
}
