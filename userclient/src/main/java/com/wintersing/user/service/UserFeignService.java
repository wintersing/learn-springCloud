package com.wintersing.user.service;

import com.wintersing.user.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice", path = "/userservice/user")
public interface UserFeignService {

    @GetMapping("/{userID}")
    User findUserByID(@PathVariable("userID") Long userID);

}
