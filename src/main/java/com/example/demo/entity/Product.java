package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable{
    @Id
    @Column(name = "product_id", nullable = false)
    private int product_id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "color", length = 10)
    private String color;

    @Column(name = "size", length = 10, nullable = false)
    private String size;

    @Column(name = "image_url", length = 100)
    private String image_url;

    // public Product (int product_id) {
    //     this.product_id = 
    // }
}
