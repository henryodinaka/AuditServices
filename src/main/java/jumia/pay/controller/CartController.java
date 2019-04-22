package jumia.pay.controller;

import jumia.pay.interfaces.CartService;
import jumia.pay.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add/cart")
    public ResponseEntity<?> addToCart()
    {
        return ResponseEntity.ok(cartService.addToCart(new Product(1L,"Cup",new BigDecimal(100),true)));
    }

    @PutMapping("/remove/cart")
    public ResponseEntity<?>  removeFromCart()
    {
       return ResponseEntity.ok(cartService.removeFromCart(new Product(1L,"Cup",new BigDecimal(100),true)));
    }

    @PostMapping("/checkout")
    public ResponseEntity<?>  checkOut(){
        return ResponseEntity.ok(cartService.checkOut());
    }
}
