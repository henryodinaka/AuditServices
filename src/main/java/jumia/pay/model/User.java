package jumia.pay.model;

import jumia.pay.interfaces.AuditingTargetUserEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    private Role role ;
}
