package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.dto.CartProductDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartProduct;
import com.example.demo.repository.CartProductRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductService {

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ModelMapper modelMapper;

    public List<CartProduct> getCartInfo(CartProductDTO cartProductDTO) {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        Cart cart = cartService.getCartByUserId(cartProductDTO.getUserId());
        List<CartProduct> getCarts = cartProducts.stream().filter(carts -> carts.getCartId() == cart.getCartId())
                                    .collect(Collectors.toList());
        return getCarts;
    }

    public CartProduct getCartInfoNotById(int cart_id, int product_id, String size, String color) {
        List<CartProduct> cartProducts = cartProductRepository.findAll();
        CartProduct getCart = cartProducts.stream().filter(carts -> carts.getCartId() == cart_id
                                    && carts.getColor().equals(color)
                                    && carts.getSize().equals(size)
                                    && carts.getProductId() == product_id).findAny().orElse(null);

        return getCart;
    }

    public int addProductToCart(CartProductDTO cartProductDTO) {
        Cart cart = cartService.getCartByUserId(cartProductDTO.getUserId());
        CartProduct cartProduct = modelMapper.map(cartProductDTO, CartProduct.class);
        cartProduct.setCartId(cart.getCartId());
        CartProduct getCart = getCartInfoNotById(cartProduct.getCartId(), cartProduct.getProductId(), cartProduct.getSize(), cartProduct.getColor());
        System.out.println(getCart);
        if (getCart != null) {
            cartProduct.setId(getCart.getId());
            cartProduct.setQuantity(cartProduct.getQuantity() + getCart.getQuantity());
        }
        cartProductRepository.save(cartProduct);
        return 1;
    }

    public int removeProductFromCart(CartProductDTO cartProductDTO) {
        cartProductRepository.deleteById(cartProductDTO.getId());
        return 1;
    }

    public int updateQuantityInCart(CartProductDTO cartProductDTO) {
        CartProduct cartProduct = cartProductRepository.findById(cartProductDTO.getId()).get();
        cartProduct.setQuantity(cartProductDTO.getQuantity());

        System.out.println(cartProduct);

        cartProductRepository.save(cartProduct);
        return 1;
    }

    public int resetCart(CartProductDTO cartProductDTO) {
        List<CartProduct> getCarts = getCartInfo(cartProductDTO);
        if (getCarts.isEmpty()) {
            return 0;
        }
        for (CartProduct cartProduct : getCarts) {
            cartProductRepository.deleteById(cartProduct.getId());
        }
        return 1;
    }
}
