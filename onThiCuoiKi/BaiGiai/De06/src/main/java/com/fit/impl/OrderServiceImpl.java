package com.fit.impl;

import com.fit.dao.OrderDao;
import com.fit.entity.Order;
import com.fit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderDao.findById(id).orElse(null);
    }

    @Override
    public Order addOrder(Order order) {
        return orderDao.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        if(!orderDao.existsById(order.getID())){
            throw new RuntimeException("Order not found: "+ order.getID());
        }else{
            return orderDao.save(order);
        }
    }
}
