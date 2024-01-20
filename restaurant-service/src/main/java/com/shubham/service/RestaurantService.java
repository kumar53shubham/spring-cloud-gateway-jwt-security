package com.shubham.service;

import com.shubham.dao.RestaurantOrderDAO;
import com.shubham.dto.OrderResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestaurantService {
    @Autowired
    private RestaurantOrderDAO orderDAO;

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId) {
        log.info("RestaurantService::getOrder :{}",orderId);
        return orderDAO.getOrders(orderId);
    }
}
