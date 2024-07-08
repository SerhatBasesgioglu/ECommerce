package com.aydakar.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String sayHello() {
        return "Hello you fuck!";
    }

    @GetMapping("admin")
    public String sayHelloAdmin() {
        return "Hello you are an admin";
    }

    @GetMapping("seller")
    public String sayHelloSeller() {
        return "Hello you are an seller";
    }

    @GetMapping("customer")
    public String sayHelloCustomer() {
        return "Hello you are an customer";
    }
}
