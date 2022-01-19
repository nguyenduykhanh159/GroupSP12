package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUserId(int userId) {
        List<Cart> carts = cartRepository.findAll();
        Cart cart = carts.stream().filter(c -> userId == c.getUserId()).findAny().orElse(null);
        return cart;
    }

    public BaseResponse addCartForUser(CartDTO cartDTO) {
        try {
            Cart cart = getCartByUserId(cartDTO.getUserId());
            if (cart != null) {
                return new BaseResponse<>(HttpStatus.BAD_REQUEST, "This user had cart");
            }
            Cart cart1 = new Cart();
            cart1.setCartId(cartDTO.getUserId());
            cart1.setUserId(cartDTO.getUserId());
            cartRepository.save(cart1);
            return new BaseResponse<>(HttpStatus.OK, "Add cart for user successfully");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Add cart for user error", e.getMessage());
        }
    }
}
