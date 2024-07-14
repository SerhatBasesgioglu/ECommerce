package com.aydakar.ecommerce.dto;

import lombok.Data;

@Data
public class CategoryRequestDto {
    private String name;
    private String parentCategory;
}
