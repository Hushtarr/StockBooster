package com.stockbooster.service;

import com.stockbooster.dto.ProductDTO;
import com.stockbooster.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    void save(ProductDTO productDTO);
    void update(Long id ,ProductDTO productDTO);
    void delete(Long id);
}
