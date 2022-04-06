package com.example.crudapp.service;

import com.example.crudapp.model.Product;
import com.example.crudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
                return productRepository.save(product);
            }
    public List<Product>   getProduct()  {
        return productRepository.findAll();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.getByName(name);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "product removed !! " + id;

    }
    public  Product updateProduct(Product product){
        Product getProductId = productRepository.findById(product.getId()).orElse(null);
        assert getProductId != null;
        getProductId.setName(product.getName());
        getProductId.setPrice(product.getPrice());
        getProductId.setQuantity(product.getQuantity());
        return productRepository.save(getProductId);

    }
}
