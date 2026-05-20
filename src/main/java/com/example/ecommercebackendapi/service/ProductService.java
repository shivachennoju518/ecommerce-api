package com.example.ecommercebackendapi.service;

import com.example.ecommercebackendapi.dto.ProductRequestDTO;
import com.example.ecommercebackendapi.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO dto);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProduct(Long id,ProductRequestDTO dto);
    void deleteProduct(Long id);
}
