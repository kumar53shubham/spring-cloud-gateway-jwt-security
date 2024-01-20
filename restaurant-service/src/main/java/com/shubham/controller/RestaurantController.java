package com.shubham.controller;

import com.shubham.dto.OrderResponseDTO;
import com.shubham.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@Slf4j
public class RestaurantController {

    @Autowired
    private RestaurantService service;

//    generating the order manually

    @GetMapping
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/orders/status/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId) {
        log.info("RestaurantController::getOrder :{}",orderId);
        return service.getOrder(orderId);
    }
}
