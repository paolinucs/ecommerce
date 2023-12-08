package it.paolone.ecommerce.controllers;
import java.util.List;
import it.paolone.ecommerce.entities.Product;
import it.paolone.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/api/products/all_products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        if(products != null && !products.isEmpty()){
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/api/products/save_product")
    public ResponseEntity<Product> saveProduct(@PathVariable Product data){
        if(data != null){
            Product saveRequest = productService.saveProduct(data);
            return ResponseEntity.ok(saveRequest);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}



