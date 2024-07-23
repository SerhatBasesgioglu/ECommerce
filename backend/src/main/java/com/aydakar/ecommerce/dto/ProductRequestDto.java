package com.aydakar.ecommerce.dto;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String name;
    private String categoryName;
    private String storeName;
}
