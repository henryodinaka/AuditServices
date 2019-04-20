package jumia.pay.service;

import jumia.pay.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private static Map<Integer,Product> products = new HashMap<>();

    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer,Product> product : products.entrySet()){
            productList.add(product.getValue());
        }
        return productList;
    }

    public void updateProduct(Integer key,Product value)
    {
        if (!products.containsKey(key))return;
        for( Map.Entry<Integer,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                product.setValue(value);
                break;
            }
        }
    }
    public void RemoveProduct(Integer key)
    {
        if (!products.containsKey(key))return;
        for( Map.Entry<Integer,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                products.remove(product);
                break;
            }
        }
    }

    static {
        Product table = new Product(1L,"Office Table",new BigDecimal(5000),true);
        products.put(table.getId().intValue(),table);
        Product chair = new Product(2L,"Office Chair",new BigDecimal(2000),true);
        products.put(chair.getId().intValue(),chair);
        Product galaxyS4  = new Product(3L,"Samsung galaxy S4",new BigDecimal(50000),true);
        products.put(galaxyS4.getId().intValue(),galaxyS4);
        Product cup = new Product(4L,"Tea Cup",new BigDecimal(300),true);
        products.put(cup.getId().intValue(),cup);
        Product pot = new Product(5L,"Italian Pot",new BigDecimal(10000),true);
        products.put(pot.getId().intValue(),pot);
        Product pen = new Product(6L,"Blue ink",new BigDecimal(100),true);
        products.put(pen.getId().intValue(),pen);
        Product bag = new Product(7L,"Apple Laptop bag",new BigDecimal(6000),true);
        products.put(bag.getId().intValue(),bag);
    }
}
