package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CartDTO {
    
    @JsonProperty
    private int userId;

    @JsonProperty
    private int cartId;
}
