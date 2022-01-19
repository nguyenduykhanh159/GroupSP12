package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart implements Serializable{

    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "user_id")
    private int userId;
}
