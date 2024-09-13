package com.java.or.controller;

import com.java.or.dto.OrderRequest;
import com.java.or.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    /*@CircuitBreaker(name = "inventory", fallbackMethod = "fallBackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")*/
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) throws IllegalAccessException {
       return CompletableFuture.supplyAsync(()-> {
           try {
               return orderService.placeOrder(orderRequest);
           } catch (IllegalAccessException e) {
               throw new RuntimeException(e);
           }
       }) ;
       // return "Order Placed Successfully";
    }

    public CompletableFuture<String> fallBackMethod(OrderRequest orderRequest, RuntimeException runtimeException){
        return  CompletableFuture.supplyAsync(()->"Oop's something went wrong, please order after sometime ");
    }
}

