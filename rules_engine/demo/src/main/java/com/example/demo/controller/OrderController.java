package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderRequest;
import com.example.demo.service.OrderValidationService;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderValidationService orderValidationService;

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Boolean> validateOrder(@RequestBody OrderRequest request) {
        return new ResponseEntity<Boolean>(orderValidationService.isOrderEliable(request), HttpStatus.OK);
    }

}
