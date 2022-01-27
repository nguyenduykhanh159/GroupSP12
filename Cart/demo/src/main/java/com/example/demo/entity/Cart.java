package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<CartProduct> cartProducts;
}
