package com.stockbooster.service.impl;

import com.stockbooster.client.ProductClient;
import com.stockbooster.dto.ProductDTO;
import com.stockbooster.dto.UserDTO;
import com.stockbooster.entity.User;
import com.stockbooster.exception.ProductNotFoundException;
import com.stockbooster.repository.ProductRepository;
import com.stockbooster.service.ProductService;
import com.stockbooster.util.MapperTool;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperTool mapper;
    private final ProductClient productClient;

    @Override
    public List<ProductDTO> findAll() {
        return List.of();
    }

    @Override
    public ProductDTO findById(Long id) {
        try {
            return productClient.getProductById(id);
        }
        catch(ProductNotFoundException exception) {
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public void save(ProductDTO productDTO) {

    }

    @Override
    public void update(Long id, ProductDTO productDTO) {

    }

    @Override
    public void delete(Long id) {

    }
}
