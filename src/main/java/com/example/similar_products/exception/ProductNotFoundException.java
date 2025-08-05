package com.example.similar_products.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("No se encontro el producto: " + id);
    }
}
