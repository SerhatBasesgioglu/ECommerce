package com.aydakar.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
   private final ProductService productService;

   public ProductController(ProductService productService) {
      this.productService = productService;
   }
}
