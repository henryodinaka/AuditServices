package jumia.pay.controller;

import jumia.pay.dto.LoginRequest;
import jumia.pay.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public void login(@RequestBody LoginRequest request){
        loginService.login(request.getUsername(),request.getPassword());
    }
}
