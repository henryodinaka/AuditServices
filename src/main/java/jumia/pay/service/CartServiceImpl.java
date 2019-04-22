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

     @Auditable(actionType = Actions.ADD_PRODUCT_TO_CART)
     public Product addToCart(Product product,String auditorEmail)
     {
         cart.put(product.getId(),product);
         return product;
     }

     @Auditable(actionType = Actions.REMOVE_PRODUCT_FROM_CART)
     public Product removeFromCart(Product product,String auditorEmail)
     {
         if(!cart.containsKey(product.getId()))return null;
         for (Map.Entry<Long,Product> p : cart.entrySet()){
             if (p.getKey().equals(product.getId())){
                 cart.remove(p);
                 break;
             }
         }
         return product;
     }

     @Auditable(actionType = Actions.CHECK_OUT)
     public List<Product> checkOut(String auditorEmail)
     {
         List<Product> products = new ArrayList<>();
         if(cart.isEmpty())return null;
         for (Map.Entry<Long,Product> p : cart.entrySet()){
             products.add(p.getValue());
             }
         return products;

     }
}
