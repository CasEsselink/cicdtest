package com.groep3.bestel.service;

import com.groep3.bestel.entities.Order;
import com.groep3.bestel.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getById(Integer id) {
        return orderRepository.getById(id);
    }

    public Order changeOrder(Order newOrder, Integer id){
        return orderRepository.findById(id)
                .map(order -> {
                    order.setOrderState(newOrder.getOrderState());
                    order.setAssignedEmployee(newOrder.getAssignedEmployee());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return orderRepository.save(newOrder);
                });
    }
}
