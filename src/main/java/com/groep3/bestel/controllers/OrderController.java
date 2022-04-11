package com.groep3.bestel.controllers;

import com.groep3.bestel.entities.Order;
import com.groep3.bestel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private SimpMessagingTemplate template;

    @Autowired
    public OrderController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @GetMapping("/orders")
    public @ResponseBody Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public @ResponseBody Order one(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PostMapping("/order")
    public @ResponseBody String addNewOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        this.template.convertAndSend("/topic/orders", order);
        return "Saved";
    }

    @PutMapping("/updateorder/{id}")
    public @ResponseBody Order updateOrder(@RequestBody Order order, @PathVariable Integer id){
        return orderService.changeOrder(order, id);
    }
}