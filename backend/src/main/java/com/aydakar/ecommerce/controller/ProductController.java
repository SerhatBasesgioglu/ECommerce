package com.aydakar.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.dto.ProductRequestDto;
import com.aydakar.ecommerce.dto.ProductResponseDto;
import com.aydakar.ecommerce.entity.Product;
import com.aydakar.ecommerce.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
   private final ProductService productService;
   private final ModelMapper modelMapper;

   public ProductController(ProductService productService, ModelMapper modelMapper) {
      this.productService = productService;
      this.modelMapper = modelMapper;
   }

   @GetMapping("")
   public ResponseEntity<List<ProductResponseDto>> getAllProducts(@RequestParam Optional<Long> storeId) {
      List<Product> productList = productService.getAllProducts(storeId);
      List<ProductResponseDto> response = productList.stream()
            .map(product -> modelMapper.map(product, ProductResponseDto.class))
            .collect(Collectors.toList());
      return ResponseEntity.ok(response);
   }

   @GetMapping("{id}")
   public ResponseEntity<ProductResponseDto> getProduct(@PathVariable long id) {
      Product product = productService.getProductById(id);
      ProductResponseDto response = modelMapper.map(product, ProductResponseDto.class);
      return ResponseEntity.ok(response);
   }

   @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
   @PostMapping("{storeId}")
   public ResponseEntity<ProductResponseDto> createProduct(@PathVariable long storeId,
         @RequestBody ProductRequestDto productRequestDto) {
      Product product = modelMapper.map(productRequestDto, Product.class);
      Product savedProduct = productService.createProduct(product, storeId);
      ProductResponseDto response = modelMapper.map(savedProduct, ProductResponseDto.class);
      return ResponseEntity.ok(response);
   }

   @PreAuthorize("hasAnyRole('ADMIN')")
   @DeleteMapping("{id}")
   public void deleteProduct(@PathVariable long id) {
      productService.deleteProductById(id);
   }
}
