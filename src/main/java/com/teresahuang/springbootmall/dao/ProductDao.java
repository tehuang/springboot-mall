package com.teresahuang.springbootmall.dao;

import com.teresahuang.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
