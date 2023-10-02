package com.stockmarket.shares.service;

import com.stockmarket.shares.entities.Product;
import com.stockmarket.shares.model.ProductResponse;

public interface ProductService {
    long addProduct(Product productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}