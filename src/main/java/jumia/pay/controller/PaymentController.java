package jumia.pay.controller;

import jumia.pay.dto.PaymentRequest;
import jumia.pay.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/pay")
    public ResponseEntity<?> makePayment() {
        return ResponseEntity.ok(paymentService.makePayment(new PaymentRequest("mine@gmail.com","2930490843848",new BigDecimal(3000),"TK394")));
    }

    @PostMapping("/reverse")
    public ResponseEntity<?> reversePayment() {
        return ResponseEntity.ok(paymentService.reversePayment(new PaymentRequest("mine@gmail.com","2930490843848",new BigDecimal(3000),"TK394")));
    }
}
