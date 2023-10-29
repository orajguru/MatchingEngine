package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.StockOrder;
import com.example.demo.models.StockOrderStatus;
import com.example.demo.models.StockOrderType;
import com.example.demo.repositories.StockOrderRepository;

@Service
public class StockOrderServiceImpl implements StockOrderService{

    StockOrderRepository stockOrderRepository;

    public StockOrderServiceImpl(StockOrderRepository stockOrderRepository){
        this.stockOrderRepository = stockOrderRepository;
    }
    
    @Override
    public List<StockOrder> getAllOrders() {
        List<StockOrder> orders = new ArrayList<>();
        stockOrderRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public List<StockOrder> getOrdersByStatus(StockOrderStatus status) {
        List<StockOrder> orders = new ArrayList<>();
        orders = stockOrderRepository.findByStatus(status.toString());
        return orders;
    }

    @Override
    public List<StockOrder> getOrderByType(StockOrderStatus status, StockOrderType type) {
        List<StockOrder> order = new ArrayList<>();
        order = stockOrderRepository.findBytype(status.toString(), type.toString());
        return order;
    }

    @Override
    public List<String> matchOrders() {
        List<StockOrder> orders = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        String res = "";
        orders = getOrdersByStatus(StockOrderStatus.PENDING);
        if(!orders.isEmpty()){
            for (StockOrder order : orders) {
                List<StockOrder> matches = new ArrayList<>();
                if(order.getType() == StockOrderType.BUY.toString()){
                    matches = stockOrderRepository.findBuyMatch(order.getStatus().toString(), order.getTickerName().toString(), StockOrderType.SELL.toString(), order.getMaxBuyPrice());
                }
                else if(order.getType() == StockOrderType.SELL.toString()){
                    matches = stockOrderRepository.findSellMatch(order.getStatus().toString(), order.getTickerName().toString(), StockOrderType.BUY.toString(), order.getMaxBuyPrice());
                }
                if(!matches.isEmpty()){
                    stockOrderRepository.updateStatus(StockOrderStatus.COMPLETED.toString(), matches.get(0).getId());
                    stockOrderRepository.updateStatus(StockOrderStatus.COMPLETED.toString(), order.getId());
                    if(order.getType() == StockOrderType.BUY.toString()){
                        res = ""+order.getTickerName()+": Seller { Id: "+matches.get(0).getId()+" } found for Buyer { Id: "+order.getId()+" }";
                    }
                    else{
                        res = ""+order.getTickerName()+": Buyer { Id: "+matches.get(0).getId()+" } found for Seller { Id: "+order.getId()+" }";
                    }
                    sol.add(res);
                }
            }
        }
        if(sol.isEmpty()){
            sol.add("No match found for any of the pending order(s)");
        }
        return sol;
    }
}
