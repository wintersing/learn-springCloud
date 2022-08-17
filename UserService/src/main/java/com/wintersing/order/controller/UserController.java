package com.wintersing.order.controller;

import com.wintersing.user.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{userID}")
    public User getUserByID(@PathVariable("userID") Long userID) {
        User user = new User();
        user.setUserID(userID);
        user.setUserName("userName" + userID);
        user.setGender("男");

        System.out.println("userservice被调用, userID:" + userID);

        return user;
    }

}
