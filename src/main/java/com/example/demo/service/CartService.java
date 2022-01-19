package com.example.demo.service;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;
import com.example.demo.response.BaseResponse;

public interface CartService {
    BaseResponse addCartForUser(CartDTO cartDTO);
    public Cart getCartByUserId(int userId);
}
