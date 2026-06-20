package com.example.ecommercebackendapi.controller;

import com.example.ecommercebackendapi.dto.CategoryRequestDTO;
import com.example.ecommercebackendapi.dto.CategoryResponseDTO;
import com.example.ecommercebackendapi.entity.Category;
import com.example.ecommercebackendapi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {
private final CategoryService categoryService;
public CategoryController(CategoryService categoryService){
    this.categoryService=categoryService;
}
@GetMapping()
    public List<CategoryResponseDTO> getAllCategories(){
    return categoryService.getAllCategories();
}
@GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id){
    return categoryService.getCategoryById(id);

}
@PostMapping()
    public CategoryResponseDTO createCategory(@Valid @RequestBody CategoryRequestDTO dto){
    return categoryService.createCategory(dto);
}
@PutMapping("/{id}")
    public CategoryResponseDTO updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO dto){
    return categoryService.updateCategory(id,dto);
}

@DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
    categoryService.deleteCategory(id);
}

}
