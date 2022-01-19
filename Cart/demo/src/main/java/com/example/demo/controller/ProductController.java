package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public BaseResponse getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping
    public BaseResponse addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
