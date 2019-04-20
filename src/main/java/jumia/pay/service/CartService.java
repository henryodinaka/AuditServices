package jumia.pay.service;

import jumia.pay.enums.Actions;
import jumia.pay.interfaces.Auditable;
import jumia.pay.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
     Map<Long, Product> cart = new HashMap<>();

    @Transactional
     @Auditable(actionType = Actions.ADD_PRODUCT_TO_CART)
     public void addToCart(Product product)
     {
         cart.put(product.getId(),product);
     }
     public void removeFromCart(Product product)
     {
         if(!cart.containsKey(product.getId()))return;
         for (Map.Entry<Long,Product> p : cart.entrySet()){
             if (p.getKey().equals(product.getId())){
                 cart.remove(p);
                 break;
             }
         }
     }
}
