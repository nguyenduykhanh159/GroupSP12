package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    public BaseResponse getAllProduct() {
        try {
            List<Product> products = productRepository.findAll();
            return new BaseResponse<>(HttpStatus.OK, "List product info", products);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Get error", e.getMessage());
        }
    }

    public BaseResponse addProduct(Product product) {
        try {
            productRepository.save(product);
            return new BaseResponse<>(HttpStatus.OK, "Add product successfully");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Get error", e.getMessage());
        }
    }
}
