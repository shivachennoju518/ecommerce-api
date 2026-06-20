package com.example.ecommercebackendapi.mapper;

import com.example.ecommercebackendapi.dto.ProductRequestDTO;
import com.example.ecommercebackendapi.dto.ProductResponseDTO;
import com.example.ecommercebackendapi.entity.Category;
import com.example.ecommercebackendapi.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDTO dto,Category category){
        Product product=new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(category);
        return product;
    }

    public ProductResponseDTO toDto(Product product){
        ProductResponseDTO dto =new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setDescription(product.getDescription());
        dto.setCategoryId(product.getCategory().getId());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }
}
