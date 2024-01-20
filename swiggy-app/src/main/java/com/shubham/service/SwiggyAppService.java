package com.shubham.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.client.RestaurantServiceClient;
import com.shubham.dto.OrderResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SwiggyAppService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;



    public String greeting() {
        return "Welcome to Swiggy App Service";
    }

    public OrderResponseDTO checkOrderStatus(String orderId) {
        log.info("SwiggyAppService::checkOrderStatus :{}",orderId);
        OrderResponseDTO orderResponseDTO=null;
        try {
            orderResponseDTO = restaurantServiceClient.fetchOrderStatus(orderId);
            log.info("SwiggyAppService::checkOrderStatus :{}",new ObjectMapper().writeValueAsString(orderResponseDTO));
        } catch (JsonProcessingException e) {
//            e.printStackTrace();
            log.info(e.getMessage());
        }

        return orderResponseDTO;
    }
}
