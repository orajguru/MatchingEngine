package com.example.demo.services;

import java.util.List;

import com.example.demo.models.StockOrder;
import com.example.demo.models.StockOrderStatus;
import com.example.demo.models.StockOrderType;

public interface StockOrderService {
    
    List<StockOrder> getAllOrders();
    
    List<StockOrder> getOrdersByStatus(StockOrderStatus status);
    
    List<StockOrder> getOrderByType(StockOrderStatus status, StockOrderType type);
    
    List<String> matchOrders();
}
