package com.example.ecommercebackendapi.controller;

import com.example.ecommercebackendapi.dto.ProductRequestDTO;
import com.example.ecommercebackendapi.dto.ProductResponseDTO;
import com.example.ecommercebackendapi.entity.Product;
import com.example.ecommercebackendapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PostMapping()
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO dto){
        return productService.createProduct(dto);
    }
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id,@RequestBody ProductRequestDTO dto){
        return productService.updateProduct(id,dto);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
