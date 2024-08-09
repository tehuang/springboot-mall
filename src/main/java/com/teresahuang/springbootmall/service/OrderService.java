package com.teresahuang.springbootmall.service;

import com.teresahuang.springbootmall.dto.CreateOrderRequest;
import com.teresahuang.springbootmall.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
