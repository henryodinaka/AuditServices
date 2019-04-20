package jumia.pay.model;

import jumia.pay.enums.UserType;
import jumia.pay.interfaces.AuditingTargetUserEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {

    private Long id;

    @NotNull
    @AuditingTargetUserEmail
    private String email;
    private String password;
    private String name;

    @Enumerated
    private UserType userType;
}
