package com.restaurant.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("orderControllerBai3")
public class OrderController {

    @GetMapping("/bai3/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") Long id) {
        return "Chi tiet don hang so " + id;
    }

}
