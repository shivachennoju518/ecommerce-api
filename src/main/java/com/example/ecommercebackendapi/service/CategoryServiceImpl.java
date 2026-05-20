package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.CategoryRequestDTO;
import com.example.ecommercebackendapi.dto.CategoryResponseDTO;
import com.example.ecommercebackendapi.entity.Category;
import com.example.ecommercebackendapi.mapper.CategoryMapper;
import com.example.ecommercebackendapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service

public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {

        Category category = categoryMapper.toEntity(dto);

        Category saved = categoryRepository.save(category);

        return categoryMapper.toDTO(saved);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());

        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
