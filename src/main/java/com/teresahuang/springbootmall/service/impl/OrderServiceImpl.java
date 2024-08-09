package com.teresahuang.springbootmall.service.impl;

import com.teresahuang.springbootmall.dao.OrderDao;
import com.teresahuang.springbootmall.dao.ProductDao;
import com.teresahuang.springbootmall.dao.UserDao;
import com.teresahuang.springbootmall.dto.BuyItem;
import com.teresahuang.springbootmall.dto.CreateOrderRequest;
import com.teresahuang.springbootmall.dto.OrderQueryParams;
import com.teresahuang.springbootmall.model.Order;
import com.teresahuang.springbootmall.model.OrderItem;
import com.teresahuang.springbootmall.model.Product;
import com.teresahuang.springbootmall.model.User;
import com.teresahuang.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        return orderDao.countOrder(orderQueryParams);
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        List<Order> orderList = orderDao.getOrders(orderQueryParams);

        for (Order order : orderList) {
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());
            order.setOrderItemList(orderItemList);
        }

        return orderList;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);
        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
        order.setOrderItemList(orderItemList);
        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        //Check if user exists
        User user = userDao.getUserById(userId);
        if(user == null) {
            log.warn("UserId {} does not exists", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem: createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            // Check if the product exists and has enough stock
            if(product == null) {
                log.warn("Product {} does not exists", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else if(product.getStock() < buyItem.getQuantity()) {
                log.warn("Product {} does not have enough stock, only {} left in stock",
                        buyItem.getProductId(), product.getStock());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //Deduct product inventory
            productDao.updateStock(product.getProductId(), product.getStock()- buyItem.getQuantity());

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
