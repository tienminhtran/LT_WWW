package com.fit.service;

import com.fit.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAll();
    public Order getById(int id);
    public Order addOrder(Order order);
    public Order updateOrder(Order order);

}
