package jumia.pay.controller;

import jumia.pay.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public ResponseEntity<?> order() {
        return null;
    }
    public ResponseEntity<?> cancelOrder() {
        return ResponseEntity.ok(orderService.cancelOrder(""));
    }
    public ResponseEntity<?> cancelCustomerOrder() {
        return ResponseEntity.ok(orderService.cancelCustomerOrder(""));
    }

    public ResponseEntity<?> getByTrackingId(String trackingNum) {
        return ResponseEntity.ok(orderService.getByTrackingId(""));
    }
}
