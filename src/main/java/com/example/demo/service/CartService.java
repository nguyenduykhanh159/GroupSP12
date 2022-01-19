package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUserId(int userId) {
        List<Cart> carts = cartRepository.findAll();
        // for (Cart cart : carts) {
        //     if (cart.getUserId() == userId) {
        //         return cart;
        //     }
        // }
        // return null;
        Cart cart = carts.stream().filter(c -> userId == c.getUserId()).findAny().orElse(null);
        return cart;
    }
}
