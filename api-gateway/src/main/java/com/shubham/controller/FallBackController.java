package com.shubham.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FallBackController {

    @GetMapping("/swiggyAppFallback")
    public String swiggyAppFallback() {
        log.info("FallBackController::swiggyAppFallback");
        return "Swiggy app is down at this time";
    }

    @GetMapping("/restaurantServiceFallback")
    public String restaurantServiceFallback() {
        log.info("FallBackController::restaurantServiceFallback");
        return "Restaurant service is under maintenance";
    }
}
