package jumia.pay.interfaces;

import jumia.pay.model.Product;

import java.util.List;

public interface CartService {
    public void addToCart(Product product, String userEmail);
    public void removeFromCart(Product product,String userEmail);
    public List<Product> checkOut(String userEmail);
}
