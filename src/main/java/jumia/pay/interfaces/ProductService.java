package jumia.pay.interfaces;

import jumia.pay.model.Product;

import java.util.List;

public interface ProductService {

    Product updateProduct(Product value, Long key);
    Product addProduct(Product product);
    Product removeProduct(Long key);
    Product viewProduct(Long key);
    List<Product> getAllProducts();
}
