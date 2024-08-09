package com.teresahuang.springbootmall.service;

import com.teresahuang.springbootmall.dto.CreateOrderRequest;
import com.teresahuang.springbootmall.dto.OrderQueryParams;
import com.teresahuang.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
