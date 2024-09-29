package com.stockbooster.service.impl;


import com.stockbooster.dto.CategoryDTO;
import com.stockbooster.entity.Category;
import com.stockbooster.exception.UserNotFoundEx;
import com.stockbooster.repository.CategoryRepository;
import com.stockbooster.service.CategoryService;
import com.stockbooster.util.GMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final GMapper mapper;
    private final CategoryRepository categoryRepository;

    @Override
    public void delete(Long id) {
       categoryRepository.findById(id).ifPresent(obj->obj.setIsDeleted(true));
       System.out.println("Category deleted");
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(obj->mapper.convert(obj,CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryRepository.save(mapper.convert(categoryDTO,Category.class));
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new UserNotFoundEx("no one"));
        return mapper.convert(category,CategoryDTO.class);

        }


    @Override
    public void update(Long id,CategoryDTO categoryDTO) {

    }
}
