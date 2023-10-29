package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.StockOrder;
import com.example.demo.services.StockOrderService;

@RestController
@RequestMapping("/api/v1/orderstock")
public class StockOrderController {
    
    StockOrderService stockOrderService;
    
    public StockOrderController(StockOrderService stockOrderService){
        this.stockOrderService = stockOrderService;
    }

    @GetMapping({"/getOrders"})
    public ResponseEntity<List<StockOrder>> getAllOrders(){
        List<StockOrder> result = stockOrderService.getAllOrders();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping({"/matchOrders"})
    public ResponseEntity<List<String>> matchOrders(){
        List<String> result = stockOrderService.matchOrders();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
