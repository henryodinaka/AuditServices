package jumia.pay.service;

import jumia.pay.enums.Actions;
import jumia.pay.interfaces.Auditable;
import jumia.pay.interfaces.CartService;
import jumia.pay.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
     Map<Long, Product> cart = new HashMap<>();

    @Transactional
     @Auditable(actionType = Actions.ADD_PRODUCT_TO_CART)
     public void addToCart(Product product,String userEmail)
     {
         cart.put(product.getId(),product);
     }

     @Transactional
     @Auditable(actionType = Actions.REMOVE_PRODUCT_FROM_CART)
     public void removeFromCart(Product product,String userEmail)
     {
         if(!cart.containsKey(product.getId()))return;
         for (Map.Entry<Long,Product> p : cart.entrySet()){
             if (p.getKey().equals(product.getId())){
                 cart.remove(p);
                 break;
             }
         }
     }

     @Auditable(actionType = Actions.CHECK_OUT)
     public List<Product> checkOut(String userEmail)
     {
         List<Product> products = new ArrayList<>();
         if(cart.isEmpty())return null;
         for (Map.Entry<Long,Product> p : cart.entrySet()){
             products.add(p.getValue());
             }
         return products;

     }
}
