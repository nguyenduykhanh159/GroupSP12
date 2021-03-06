package com.example.demo.controller;

import com.example.demo.dto.CartProductDTO;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.CartProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/cart")
public class CartProductController {
    
    @Autowired
    private CartProductService cartProductService;

    @PostMapping("/addProduct")
    public BaseResponse addProductToCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.addProductToCart(cartProductDTO);
    }

    @PostMapping
    public BaseResponse getCartInfo(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.getCartInfo(cartProductDTO);
    }

    @DeleteMapping
    public BaseResponse removeProductFromCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.removeProductFromCart(cartProductDTO);
    }

    @PatchMapping
    public BaseResponse updateQuantityInCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.updateQuantityInCart(cartProductDTO);
    }

    @PostMapping("/removeAll")
    public BaseResponse resetCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.resetCart(cartProductDTO);
    }
}
