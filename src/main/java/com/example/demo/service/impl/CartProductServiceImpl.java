package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.CartProductDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProduct;
import com.example.demo.repository.CartProductRepository;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.CartProductService;
import com.example.demo.service.CartService;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImpl implements CartProductService{
    
    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ModelMapper modelMapper;

    public BaseResponse getCartInfo(CartProductDTO cartProductDTO) {
        try {
            List<CartProduct> cartProducts = cartProductRepository.findAll();
            Cart cart = cartService.getCartByUserId(cartProductDTO.getUserId());
            List<CartProduct> getCarts = cartProducts.stream().filter(carts -> carts.getCart().getCartId() == cart.getCartId())
                                    .collect(Collectors.toList());
            return new BaseResponse<>(HttpStatus.OK, "Cart info", getCarts);
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Get error", e.getMessage());
        }
    }

    public CartProduct getCartInfoNotById(int cart_id, int product_id, String size, String color) {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        CartProduct getCart = cartProducts.stream().filter(carts -> carts.getCart().getCartId() == cart_id
                                    && carts.getColor().equals(color)
                                    && carts.getSize().equals(size)
                                    && carts.getProductId() == product_id).findAny().orElse(null);

        return getCart;
    }

    public BaseResponse addProductToCart(CartProductDTO cartProductDTO) {
        try {
            Cart cart = cartService.getCartByUserId(cartProductDTO.getUserId());
            CartProduct cartProduct = modelMapper.map(cartProductDTO, CartProduct.class);
            cartProduct.getCart().setCartId(cart.getCartId());
            CartProduct getCart = getCartInfoNotById(cartProduct.getCart().getCartId(), cartProduct.getProductId(), cartProduct.getSize(), cartProduct.getColor());
            System.out.println(getCart);
            if (getCart != null) {
                cartProduct.setId(getCart.getId());
                cartProduct.setQuantity(cartProduct.getQuantity() + getCart.getQuantity());
            }
            cartProductRepository.save(cartProduct);
            return new BaseResponse<>(HttpStatus.OK, "Add successfully");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Add error", e.getMessage());
        }
    }

    public BaseResponse removeProductFromCart(CartProductDTO cartProductDTO) {
        try {
            cartProductRepository.deleteById(cartProductDTO.getId());
            return new BaseResponse<>(HttpStatus.OK, "Delete successfully");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Delete error", e.getMessage());
        }
    }

    public BaseResponse updateQuantityInCart(CartProductDTO cartProductDTO) {
        try {
            CartProduct cartProduct = cartProductRepository.findById(cartProductDTO.getId()).get();
            cartProduct.setQuantity(cartProductDTO.getQuantity());
            cartProductRepository.save(cartProduct);
            return new BaseResponse<>(HttpStatus.OK, "Update quantity successfully");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Update quantity error", e.getMessage());
        }
    }

    public List<CartProduct> getCart(CartProductDTO cartProductDTO) {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        Cart cart = cartService.getCartByUserId(cartProductDTO.getUserId());
        List<CartProduct> getCarts = cartProducts.stream().filter(carts -> carts.getCart().getCartId() == cart.getCartId())
                                    .collect(Collectors.toList());
        return getCarts;
    }

    public BaseResponse resetCart(CartProductDTO cartProductDTO) {
        try {
            List<CartProduct> getCarts = getCart(cartProductDTO);
            if (getCarts.isEmpty()) {
                return new BaseResponse<>(HttpStatus.OK, "Not have product in cart");
            }
            for (CartProduct cartProduct : getCarts) {
                cartProductRepository.deleteById(cartProduct.getId());
            }
            return new BaseResponse<>(HttpStatus.OK, "Reset successfully");
        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Reset Error", e.getMessage());
        }
    }
}
