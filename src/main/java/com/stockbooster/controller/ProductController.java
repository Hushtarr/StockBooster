package com.stockbooster.controller;

import com.stockbooster.dto.ProductDTO;
import com.stockbooster.dto.common.ApiInfo;
import com.stockbooster.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Product Crud Services",
        description = "More operations are coming "
)
@RestController
@RequestMapping(
        value = "/api/",
        produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/public/products/{id}")
    public ResponseEntity<ApiInfo<ProductDTO>>findById(@PathVariable("id") Long id) {
        ProductDTO product = productService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiInfo.successReturn("Product found",product));
    }
}
