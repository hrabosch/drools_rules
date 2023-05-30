package com.example.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class Account {
    private String uid;
    private String accountName;
    private List<String> allowedSymbols;
    private Integer perOrderAmountLimit;

}
