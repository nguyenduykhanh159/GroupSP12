package com.example.demo.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_in_cart")
@Data
public class CartProduct implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="cart_id")
    private int cartId;

    @Column(name="product_id")
    private int productId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "color", length = 10)
    private String color;

    @Column(name = "size", length = 10, nullable = false)
    private String size;

    @Column(name = "image_url", length = 100)
    private String image_url;
}
