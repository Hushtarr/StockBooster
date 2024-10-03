package com.stockbooster.client;

import com.stockbooster.dto.CategoryDTO;
import com.stockbooster.entity.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "category",url = "https://dummyjson.com/products")
public interface CategoryClient {
    @GetMapping("/categories")
    List<CategoryDTO> getCategories();
}
