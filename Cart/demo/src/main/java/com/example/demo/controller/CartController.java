package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.CartProductDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProduct;
import com.example.demo.service.CartProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/cart")
public class CartController {
    
    @Autowired
    private CartProductService cartProductService;

    @PostMapping("/addProduct")
    public int addProductToCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.addProductToCart(cartProductDTO);
    }

    @PostMapping
    public List<CartProduct> getCartInfo(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.getCartInfo(cartProductDTO);
    }

    @DeleteMapping
    public int removeProductFromCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.removeProductFromCart(cartProductDTO);
    }

    @PatchMapping
    public int updateQuantityInCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.updateQuantityInCart(cartProductDTO);
    }

    @GetMapping("/removeAll")
    public int resetCart(@RequestBody CartProductDTO cartProductDTO) {
        return cartProductService.resetCart(cartProductDTO);
    }
}
