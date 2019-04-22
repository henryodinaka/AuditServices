package jumia.pay.interfaces;

import jumia.pay.model.Product;

public interface ProductService {

    public Product updateProduct(Product value, String userEmail, Integer key);
    public Product addProduct(Product product,String userEmail,Integer key);
    public Product RemoveProduct(Long key,String userEmail);
    public Product viewProduct(Long key,String userEmail);
}
