package jumia.pay.controller;

import jumia.pay.interfaces.ProductService;
import jumia.pay.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(Integer key)
    {
        return ResponseEntity.ok(productService.updateProduct(new Product(1L,"Cup",new BigDecimal(100),true),1L));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct()
    {
        return ResponseEntity.ok(new Product(1L,"Cup",new BigDecimal(100),true));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> RemoveProduct()
    {

        return ResponseEntity.ok(productService.removeProduct(1L));
    }

    @GetMapping("/viewOne")
    public ResponseEntity<?> viewProduct()
    {
        return ResponseEntity.ok(productService.viewProduct(1L));
    }
}
