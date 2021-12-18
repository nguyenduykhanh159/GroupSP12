package com.example.demo.api;

import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
	public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}
}
