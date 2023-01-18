package com.example.demo;

class ProductNotFoundException extends RuntimeException  {
    ProductNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
