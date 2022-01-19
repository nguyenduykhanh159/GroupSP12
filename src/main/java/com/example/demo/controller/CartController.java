package com.example.demo.controller;

import com.example.demo.dto.CartDTO;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/cartUser")
public class CartController {
    
    @Autowired
    private CartService cartService;

    @PostMapping
    public int addCartForUser(@RequestBody CartDTO cartDTO) {
        return cartService.addCartForUser(cartDTO);
    }
}
