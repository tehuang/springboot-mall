package com.teresahuang.springbootmall.service.impl;

import com.teresahuang.springbootmall.dao.OrderDao;
import com.teresahuang.springbootmall.dao.ProductDao;
import com.teresahuang.springbootmall.dto.BuyItem;
import com.teresahuang.springbootmall.dto.CreateOrderRequest;
import com.teresahuang.springbootmall.model.OrderItem;
import com.teresahuang.springbootmall.model.Product;
import com.teresahuang.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem: createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
            //Calculate total amount
            int amount = product.getPrice() * buyItem.getQuantity();
            totalAmount += amount;

            //butItem to orderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);
            orderItemList.add(orderItem);
        }

        //Create Order
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
