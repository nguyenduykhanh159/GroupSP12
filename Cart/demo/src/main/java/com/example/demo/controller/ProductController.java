package com.example.demo.controller;

import com.example.demo.response.BaseResponse;
import com.example.demo.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public BaseResponse getAllProduct() {
        return productService.getAllProduct();
    }
}
