package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart implements Serializable{

    @Id
    @Column(name = "cart_id", nullable = false)
    private int cartId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @OneToMany(mappedBy = "cart")
    private Set<CartProduct> cartProducts;
}
