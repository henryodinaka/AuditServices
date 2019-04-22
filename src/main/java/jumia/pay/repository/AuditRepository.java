package jumia.pay.repository;

import jumia.pay.model.Audit;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;

public interface AuditRepository extends MongoRepository<Audit,ObjectId> {
    @Query("{'createdDate': {$gte: ?0, $lte:?1 }}")
    Page<Audit> findActivitieBetween(Date startDate, Date endDate, Pageable pageable);
}
