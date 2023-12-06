package it.paolone.ecommerce.services;
import it.paolone.ecommerce.entities.Product;
import it.paolone.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id){
        Optional<Product> fetchedProduct = productRepository.findById(id);
        return fetchedProduct.orElse(null);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product data){
        return productRepository.save(data);
    }

}
