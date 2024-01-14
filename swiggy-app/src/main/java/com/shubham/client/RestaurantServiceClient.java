package com.shubham.client;

import com.shubham.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
public class RestaurantServiceClient {

    @Value("${microservice.restaurant-service.endpoints.fetchOrderById.uri}")
    private String fetchOrderUri;

    @Value("${test.input}")
    private String testValue;

    @Autowired
    private RestTemplate template;

    public OrderResponseDTO fetchOrderStatus(String orderId) {
        System.out.println("*************** "+testValue);
        System.out.println("fetchOrderUri : "+fetchOrderUri);
        return template.getForObject(fetchOrderUri + orderId, OrderResponseDTO.class);
    }
}
