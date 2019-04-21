package jumia.pay.interfaces;

import jumia.pay.model.Product;

public interface ProductService {

    public void updateProduct(Product value, String userEmail, Integer key);
    public void addProduct(Product product,String userEmail,Integer key);
    public void RemoveProduct(Integer key,String userEmail);
    public Product viewProduct(Integer key,String userEmail);
}
