package com.teresahuang.springbootmall.service;

import com.teresahuang.springbootmall.constant.ProductCategory;
import com.teresahuang.springbootmall.dto.ProductQueryParams;
import com.teresahuang.springbootmall.dto.ProductRequest;
import com.teresahuang.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    Integer countProduct(ProductQueryParams productQueryParams);
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
