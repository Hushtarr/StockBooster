package com.stockbooster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/product")
    public String product() {
        return "product";
    }
}
/*
 @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts(); // 假设这是从数据库中获取产品数据的服务
        if (products.isEmpty()) {
            // 如果没有产品，你可以添加一些测试数据
            products = Arrays.asList(
                    new Product(1, "Test Product 1", "images/product-1.jpg", 100, 80),
                    new Product(2, "Test Product 2", "images/product-2.jpg", 150, 120)
            );
        }
        model.addAttribute("products", products);
        return "product-page"; // 对应你的HTML文件名
    }*/