package jumia.pay.repository;

import jumia.pay.model.Audit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditRepository extends MongoRepository<Audit,ObjectId> {
}
