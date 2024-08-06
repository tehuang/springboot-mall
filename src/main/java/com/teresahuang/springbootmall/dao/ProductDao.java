package com.teresahuang.springbootmall.dao;

import com.teresahuang.springbootmall.dto.ProductRequest;
import com.teresahuang.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
