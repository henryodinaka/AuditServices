package jumia.pay.service;
 
import jumia.pay.enums.UserType;
import jumia.pay.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    static Map<Integer,User> users = new HashMap<>();

    public User getUserById(Integer id){
        return users.get(id);
    }

    static {
        User jane = new User(1L,"jane@jumiapay.com","password123","Jane", UserType.CUSTOMERSERVICE);
        User peter =  new User(2L,"peter@jumiapay.com","password123","Pater", UserType.CUSTOMERSERVICE);
        User josh =  new User(3L,"josh@jumiapay.com","password123","Josh", UserType.CUSTOMER);
        User ken =  new User(4L,"ken@jumiapay.com","password123","Ken", UserType.CUSTOMER);
        User silva =  new User(5L,"silva@jumiapay.com","password123","Silva", UserType.OPERATION);
        User tim =  new User(6L,"tim@jumiapay.com","password123","Tim", UserType.OPERATION);

        users.put(jane.getId().intValue(),jane);
        users.put(peter.getId().intValue(),peter);
        users.put(josh.getId().intValue(),josh);
        users.put(ken.getId().intValue(),ken);
        users.put(silva.getId().intValue(),silva);
        users.put(tim.getId().intValue(),tim);
    }
}
