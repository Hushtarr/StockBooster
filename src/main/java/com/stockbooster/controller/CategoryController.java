package com.stockbooster.controller;


import com.stockbooster.dto.ApiMsg;
import com.stockbooster.dto.CategoryDTO;
import com.stockbooster.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<CategoryDTO>> findAllCategory() {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(categoryService.findAll());
    }

    @GetMapping("/public/categories/{id}")
    public ResponseEntity<CategoryDTO> findCategoryById (@PathVariable Long id) {
        return  ResponseEntity
                .status(HttpStatus.FOUND)
                .header("IM")// just a random header
                .body(categoryService.findById(id));
        /*在 ResponseEntity 的构建过程中，顺序是很重要的，
        因为每个方法调用都会返回一个新的 ResponseEntity.Builder 实例，并且这个实例会依赖之前的设置。
        因此，调用的顺序需要遵循下面的逻辑：
        状态码设置 (status())：这是最基础的，通常最先调用，因为它会定义响应的 HTTP 状态码。
        添加头部 (header())：在设置状态码后，可以添加头部信息。
        设置响应体 (body())：最后调用 body() 来设置响应体，body() 一旦调用，构建器就会返回一个完整的 ResponseEntity，因此它应该是最后一步。
        换句话说，body() 方法必须是最后调用的，因为它完成了 ResponseEntity 的构建。*/

    }

    @PostMapping("/admin/categories")
    public ResponseEntity<Void> addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
        System.out.println("Category added");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(null);
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<ApiMsg> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity
                .ok(new ApiMsg("delete category successful"));
        /*ResponseEntity.noContent()：
        创建一个 ResponseEntity 构建器，它设置状态码为 204 No Content。
        204 No Content 表示请求成功，但没有返回任何内容。
        此时你可以调用 build() 完成 ResponseEntity 对象的创建*/
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        categoryService.update(id, categoryDTO);
        return ResponseEntity.noContent().build();

    }

}
