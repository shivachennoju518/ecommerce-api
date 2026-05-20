package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.CategoryRequestDTO;
import com.example.ecommercebackendapi.dto.CategoryResponseDTO;
import com.example.ecommercebackendapi.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO dto);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Long id);

    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);

    void deleteCategory(Long id);

}
