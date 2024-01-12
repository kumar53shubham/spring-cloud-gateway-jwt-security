package com.shubham.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/swiggyAppFallback")
    public String swiggyAppFallback() {
        return "Swiggy app is down at this time";
    }

    @GetMapping("/restaurantServiceFallback")
    public String restaurantServiceFallback() {
        return "Restaurant service is under maintainance";
    }
}
