package com.stockbooster.service;


import com.stockbooster.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findById(Long id);
    void save(CategoryDTO categoryDTO);
    void update(Long id,CategoryDTO categoryDTO);
    void delete(Long id);
}
