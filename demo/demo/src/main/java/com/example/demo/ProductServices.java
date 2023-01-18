package com.example.demo;

import java.util.List;

public interface ProductServices {
    List<Product> getAllProduct();

    Product getAProduct(Long id);

    Product addProduct(Product product);

    Product updateProduct(Product newProduct, Long id);

    void deleteProduct(Long id);
}