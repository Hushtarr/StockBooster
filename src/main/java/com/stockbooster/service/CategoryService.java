package com.stockbooster.service;


import com.stockbooster.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
    void save(CategoryDTO categoryDTO);
    CategoryDTO findById(Long id);
    void update(Long id,CategoryDTO categoryDTO);
    void delete(Long id);
}
