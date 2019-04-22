package jumia.pay.interfaces;

import jumia.pay.model.Product;

import java.util.List;

public interface OrderService {
    String order(List<Product> products);
    String cancelOrder(String trackingNum);
    String getByTrackingId(String trackingNum);
    String cancelCustomerOrder(String trackingNum);
}
