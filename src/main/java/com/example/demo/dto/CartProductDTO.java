package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CartProductDTO {
    
    private int userId;

    @JsonProperty
    private int id;
    
    @JsonProperty
    private int cartId;

    @JsonProperty
    private int productId;

    @JsonProperty
    private String name;

    @JsonProperty
    private int price;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private String color;

    @JsonProperty
    private String size;

    @JsonProperty
    private String image_url;
}
