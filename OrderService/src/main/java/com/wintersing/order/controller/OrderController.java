package com.wintersing.order.controller;

import com.wintersing.user.bean.Order;
import com.wintersing.user.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/{orderID}")
    public Order getUserByID(@PathVariable("orderID") Long orderID) {
        Order order = new Order();
        order.setOrderID(orderID);
        order.setOrderName("orderName" + orderID);

        Long userID = orderID * 2;
        order.setUserID(userID);
        order.setUser(userFeignService.findUserByID(userID));

        return order;
    }

}
