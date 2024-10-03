package com.stockbooster.controller;


import com.stockbooster.dto.CategoryDTO;
import com.stockbooster.dto.common.ApiInfo;
import com.stockbooster.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Category Crud Services",
        description = "More operations are coming "
)
@CrossOrigin("http://localhost:8080*")
@RestController
@RequestMapping(
        value = "/api/",
        produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<ApiInfo<List<CategoryDTO>>> findAllCategory() {
        List<CategoryDTO> categoryList=categoryService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Here's the category list",categoryList));
    }

    @GetMapping("/public/categories/{id}")
    public ResponseEntity<ApiInfo<CategoryDTO>> findCategoryById (@PathVariable Long id) {
        CategoryDTO category=categoryService.findById(id);
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Here's the category you looking for:",category));
    }

    @PostMapping("/admin/categories")
    public ResponseEntity<ApiInfo<Void>> addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiInfo.successVoid("Category added"));
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<ApiInfo<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( ApiInfo.successVoid("category deleted"));
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<ApiInfo<Void>> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        categoryService.update(id, categoryDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successVoid("Category updated successfully"));

    }

}
