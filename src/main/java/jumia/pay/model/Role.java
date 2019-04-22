package jumia.pay.model;

import jumia.pay.enums.RoleName;
import lombok.Data;

import javax.persistence.*;

@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public Role(RoleName name) {
        this.name = name;
    }
}