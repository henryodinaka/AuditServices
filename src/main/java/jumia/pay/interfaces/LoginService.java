package jumia.pay.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService {

    String findLoggedInUsername();

    UserDetails login(String username, String password);
}
