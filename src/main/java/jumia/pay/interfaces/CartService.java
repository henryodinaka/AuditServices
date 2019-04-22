package jumia.pay.interfaces;

import jumia.pay.model.Product;

import java.util.List;

public interface CartService {
    public Product addToCart(Product product, String userEmail);
    public Product removeFromCart(Product product,String userEmail);
    public List<Product> checkOut(String userEmail);
}
