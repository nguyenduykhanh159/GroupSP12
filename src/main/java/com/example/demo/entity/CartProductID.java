package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CartProductID implements Serializable{
    
    @Column(name="cart_id")
    private int cartId;

    @Column(name="product_id")
    private int productId;
}
