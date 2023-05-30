package com.example.demo.model;

import lombok.Data;

@Data
public class Order {
    private String symbol;
    private Account account;
    private Integer quantity;
    private Boolean eliable;
}
