package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product createProduct(ProductRequest productRequest);

    Product readProduct(Long productId);

    Product updateProduct(Long productId, ProductRequest productRequest);

    void deleteProduct(Long productId);
}
