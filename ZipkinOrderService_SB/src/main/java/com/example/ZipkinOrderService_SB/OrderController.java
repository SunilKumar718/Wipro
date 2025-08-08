package com.example.ZipkinOrderService_SB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String placeOrder(){
        String paymentResponse= restTemplate.getForObject("http://localhost:8082/payment", String.class);
        return "Order Placed. Payment Status: " + paymentResponse;
    }
}
