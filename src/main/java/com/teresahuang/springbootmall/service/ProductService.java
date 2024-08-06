package com.teresahuang.springbootmall.service;

import com.teresahuang.springbootmall.dto.ProductRequest;
import com.teresahuang.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
