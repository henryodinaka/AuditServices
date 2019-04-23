package jumia.pay.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mongodb.DBObject;
import jumia.pay.enums.Actions;
import jumia.pay.enums.RoleName;
import jumia.pay.util.JsonDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;

import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit {
    @Id
    private ObjectId id;

    @Enumerated(EnumType.STRING)
    private Actions action;

    private String targetObject;

    @CreatedDate
    @JsonSerialize(using = JsonDateSerializer.class)
    @Temporal(TIMESTAMP)
    private Date createdDate;

    private String userEmail;

    @Enumerated (EnumType.STRING)
    private RoleName roleName;

    public Audit( Actions action, String userEmail, RoleName roleName) {
        this.action = action;
        this.userEmail = userEmail;
        this.roleName = roleName;
    }
}
