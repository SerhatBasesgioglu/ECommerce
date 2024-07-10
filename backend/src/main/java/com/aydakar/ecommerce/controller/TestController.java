package com.aydakar.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("admin")
    public String sayHelloAdmin() {
        return "Hi admin";
    }

    @GetMapping("seller")
    public String sayHelloSeller() {
        return "Hi seller";
    }

    @GetMapping("customer")
    public String sayHelloCustomer() {
        return "Hello customer";
    }
}
