package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {

    private String accountUid;
    private String symbol;
    private Integer quantity;
    private List<String> productTypes;

}
