package com.example.demo.service;

import com.example.demo.dto.CartProductDTO;
import com.example.demo.response.BaseResponse;

public interface CartProductService {
    public BaseResponse getCartInfo(CartProductDTO cartProductDTO);
    public BaseResponse addProductToCart(CartProductDTO cartProductDTO);
    public BaseResponse removeProductFromCart(CartProductDTO cartProductDTO);
    public BaseResponse updateQuantityInCart(CartProductDTO cartProductDTO);
    public BaseResponse resetCart(CartProductDTO cartProductDTO);
}
