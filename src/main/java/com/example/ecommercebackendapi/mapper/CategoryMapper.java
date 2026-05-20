package com.example.ecommercebackendapi.mapper;

import com.example.ecommercebackendapi.dto.CategoryRequestDTO;
import com.example.ecommercebackendapi.dto.CategoryResponseDTO;
import com.example.ecommercebackendapi.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }

    public CategoryResponseDTO toDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}
