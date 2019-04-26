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
    public Product updateProduct(Product value,Long key)
    {
        if (!products.containsKey(key))return null;
        for( Map.Entry<Long,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                product.setValue(value);
                break;
            }
        }
        return value;
    }

    @Auditable(actionType = Actions.ADD_PRODUCT_TO_STORE)
    public Product addProduct(Product product)
    {
        if (product !=null)return null;
        products.put(product.getId(),product);
        return product;
    }
    @Auditable(actionType = Actions.REMOVE_PRODUCT_FROM_STORE)
    public Product removeProduct(Long key)
    {
        Product removedProduct =null;
        if (!products.containsKey(key))return null;
        for( Map.Entry<Long,Product> product : products.entrySet() ) {
            if (product.getKey().equals(key)) {
                removedProduct = product.getValue();
                products.remove(product);
                break;
            }
        }
        return removedProduct;
    }
    @Auditable(actionType = Actions.VIEW_PRODUCT)
    public Product viewProduct(Long key)
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
        Product chair = new Product(2L,"Office Chair",new BigDecimal(2000),true);
        Product galaxyS4  = new Product(3L,"Samsung galaxy S4",new BigDecimal(50000),true);
        Product cup = new Product(4L,"Tea Cup",new BigDecimal(300),true);
        Product pot = new Product(5L,"Italian Pot",new BigDecimal(10000),true);
        Product pen = new Product(6L,"Blue ink",new BigDecimal(100),true);
        Product bag = new Product(7L,"Apple Laptop bag",new BigDecimal(6000),true);
        products.put(table.getId(),table);
        products.put(chair.getId(),chair);
        products.put(galaxyS4.getId(),galaxyS4);
        products.put(cup.getId(),cup);
        products.put(pot.getId(),pot);
        products.put(pen.getId(),pen);
        products.put(bag.getId(),bag);
    }
}
