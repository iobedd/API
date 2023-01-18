package com.example.demo;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/products")
    List<Product> all() {
        return productService.getAllProduct();
    }
    // end::get-aggregate-root[]

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    // Single item

    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return productService.getAProduct(id);
    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productService.updateProduct(newProduct, id);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
