package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class ProductService implements ProductServices {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProduct(){
        return repository.findAll();
    }
    @Override
    public Product getAProduct(Long id){
        return repository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
    }
    @Override
    public Product addProduct(Product product){

        return repository.save(product);
    }
    @Override
    public Product updateProduct(Product newProduct, Long id){

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setDetails(newProduct.getDetails());
                    product.setLicense(newProduct.getLicencePlate());
                    return repository.save(product);
                })
                .orElseGet(()->{
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }
    @Override
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }
}