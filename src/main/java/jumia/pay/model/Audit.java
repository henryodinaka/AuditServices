package jumia.pay.model;

import com.mongodb.DBObject;
import jumia.pay.enums.Actions;
import jumia.pay.enums.RoleName;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;

import static javax.persistence.TemporalType.TIMESTAMP;

@Document
@Data
public class Audit {
    @Id
    private ObjectId id;

    @Enumerated(EnumType.STRING)
    private Actions action;

    private DBObject targetObject;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private String createdDate;

    @CreatedBy
    private String userEmail;

    @Enumerated (EnumType.STRING)
    private RoleName roleName;
}
