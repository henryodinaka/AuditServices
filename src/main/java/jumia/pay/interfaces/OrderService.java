package jumia.pay.interfaces;

import jumia.pay.model.Product;

import java.util.List;

public interface OrderService {
    String order(List<Product> products,String userEmail);
    String cancelOrder(String trackingNum,String userEmail);
}
