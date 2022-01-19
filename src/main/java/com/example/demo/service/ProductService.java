package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.response.BaseResponse;

public interface ProductService {
    public BaseResponse getAllProduct();
    public BaseResponse addProduct(Product product);
}
