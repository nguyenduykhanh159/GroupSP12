package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CartDTO;
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
        Cart cart = carts.stream().filter(c -> userId == c.getUserId()).findAny().orElse(null);
        return cart;
    }

    public int addCartForUser(CartDTO cartDTO) {
        Cart cart = getCartByUserId(cartDTO.getUserId());
        if (cart != null) {
            return 0;
        }
        Cart cart1 = new Cart();
        cart1.setCartId(cartDTO.getUserId());
        cart1.setUserId(cartDTO.getUserId());
        cartRepository.save(cart1);
        return 1;
    }
}
