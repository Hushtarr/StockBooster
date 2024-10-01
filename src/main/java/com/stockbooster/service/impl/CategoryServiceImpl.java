package com.stockbooster.service.impl;


import com.stockbooster.dto.CategoryDTO;
import com.stockbooster.entity.Category;
import com.stockbooster.exception.CategoryNotFoundException;
import com.stockbooster.exception.IllegalArgumentException;
import com.stockbooster.repository.CategoryRepository;
import com.stockbooster.service.CategoryService;
import com.stockbooster.util.MapperTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final MapperTool mapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void delete(Long id) {
       Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category not found"));
       category.setIsDeleted(true);
       categoryRepository.save(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAllByIsDeletedFalse().stream()
                .map(obj->mapper.convert(obj,CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryRepository.save(mapper.convert(categoryDTO,Category.class));
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new IllegalArgumentException("no such Category"));
        return mapper.convert(category,CategoryDTO.class);
        }


    @Override
    public void update(Long id,CategoryDTO categoryDTO) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("no such Category"));
        categoryDTO.setId(category.getId());
        save(categoryDTO);
    }
}
