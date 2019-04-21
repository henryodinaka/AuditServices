package jumia.pay.service;

import jumia.pay.enums.Actions;
import jumia.pay.interfaces.Auditable;
import jumia.pay.interfaces.ProductService;
import jumia.pay.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    private static Map<Long,Product> products = new HashMap<>();

    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Long,Product> product : products.entrySet()){
            productList.add(product.getValue());
        }
        return productList;
    }
    @Auditable(actionType = Actions.UPDATE_PRODUCT)
    public void updateProduct(Product value,String userEmail,Integer key)
    {
        if (!products.containsKey(key))return;
        for( Map.Entry<Long,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                product.setValue(value);
                break;
            }
        }
    }

    @Auditable(actionType = Actions.ADD_PRODUCT_TO_STORE)
    public void addProduct(Product product,String userEmail,Integer key)
    {
        if (product !=null)return;
        products.put(product.getId(),product);
    }
    @Auditable(actionType = Actions.REMOVE_PRODUCT_FROM_STORE)
    public void RemoveProduct(Integer key,String userEmail)
    {
        if (!products.containsKey(key))return;
        for( Map.Entry<Long,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                products.remove(product);
                break;
            }
        }
    }
    @Auditable(actionType = Actions.VIEW_PRODUCT)
    public Product viewProduct(Integer key,String userEmail)
    {
        if (!products.containsKey(key))return null;
        for( Map.Entry<Long,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                return product.getValue();
            }
        }return null;
    }

    static {
        Product table = new Product(1L,"Office Table",new BigDecimal(5000),true);
        products.put(table.getId(),table);
        Product chair = new Product(2L,"Office Chair",new BigDecimal(2000),true);
        products.put(chair.getId(),chair);
        Product galaxyS4  = new Product(3L,"Samsung galaxy S4",new BigDecimal(50000),true);
        products.put(galaxyS4.getId(),galaxyS4);
        Product cup = new Product(4L,"Tea Cup",new BigDecimal(300),true);
        products.put(cup.getId(),cup);
        Product pot = new Product(5L,"Italian Pot",new BigDecimal(10000),true);
        products.put(pot.getId(),pot);
        Product pen = new Product(6L,"Blue ink",new BigDecimal(100),true);
        products.put(pen.getId(),pen);
        Product bag = new Product(7L,"Apple Laptop bag",new BigDecimal(6000),true);
        products.put(bag.getId(),bag);
    }
}