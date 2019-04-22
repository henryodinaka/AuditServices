package jumia.pay.service;

import jumia.pay.enums.RoleName;
import jumia.pay.interfaces.UserService;
import jumia.pay.model.Role;
import jumia.pay.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    static Map<String ,User> users = new HashMap<>();

    public User getUserById(Integer id){
        return users.get(id);
    }

    public User findByUsername(String username) {
        for (Map.Entry<String,User> user: users.entrySet())
        {
            if (user.getValue().getEmail().equalsIgnoreCase(username))return user.getValue();
        }
        return null;
    }

    static {
        User jane = new User(1L,"jane@jumiapay.com","password123","Jane", new Role(RoleName.CUSTOMERSERVICE));
        User peter =  new User(2L,"peter@jumiapay.com","password123","Pater", new Role(RoleName.CUSTOMERSERVICE));
        User josh =  new User(3L,"josh@jumiapay.com","password123","Josh", new Role( RoleName.CUSTOMER));
        User ken =  new User(4L,"ken@jumiapay.com","password123","Ken", new Role(RoleName.CUSTOMER));
        User silva =  new User(5L,"silva@jumiapay.com","password123","Silva",new Role( RoleName.OPERATION));
        User tim =  new User(6L,"tim@jumiapay.com","password123","Tim", new Role(RoleName.OPERATION));

        users.put(jane.getEmail(),jane);
        users.put(peter.getEmail(),peter);
        users.put(josh.getEmail(),josh);
        users.put(ken.getEmail(),ken);
        users.put(silva.getEmail(),silva);
        users.put(tim.getEmail(),tim);
    }
}
