package jumia.pay.interfaces;

import jumia.pay.model.Product;

import java.util.List;

public interface CartService {
    Product addToCart(Product product );
    Product removeFromCart(Product product);
    List<Product> checkOut();
}
