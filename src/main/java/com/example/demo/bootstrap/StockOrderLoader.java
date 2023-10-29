package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.models.StockOrder;
import com.example.demo.models.StockOrderStatus;
import com.example.demo.models.StockOrderType;
import com.example.demo.models.Ticker;
import com.example.demo.repositories.StockOrderRepository;

@Component
public class StockOrderLoader implements CommandLineRunner{
    public final StockOrderRepository stockOrderRepository;

    public StockOrderLoader(StockOrderRepository stockOrderRepository){
        this.stockOrderRepository = stockOrderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadRepository();
    }

    private void loadRepository(){
        if (stockOrderRepository.count() == 0) {
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.BUY.toString())
                            .maxBuyPrice(110.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.SELL.toString())
                            .minSellPrice(95.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.SELL.toString())
                            .minSellPrice(120.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.BUY.toString())
                            .minSellPrice(63.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.BUY.toString())
                            .minSellPrice(42.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.SELL.toString())
                            .minSellPrice(442.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.TATA.toString())
                            .type(StockOrderType.SELL.toString())
                            .minSellPrice(432.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.BUY.toString())
                            .minSellPrice(20.00)
                            .maxBuyPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.SELL.toString())
                            .maxBuyPrice(20.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.BUY.toString())
                            .maxBuyPrice(240.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.SELL.toString())
                            .maxBuyPrice(1220.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.SELL.toString())
                            .maxBuyPrice(600.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.BUY.toString())
                            .maxBuyPrice(203.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.BUY.toString())
                            .maxBuyPrice(300.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );
            stockOrderRepository.save(
                    StockOrder.builder()
                            .tickerName(Ticker.RELIANCE.toString())
                            .type(StockOrderType.SELL.toString())
                            .maxBuyPrice(301.00)
                            .minSellPrice(0.00)
                            .status(StockOrderStatus.PENDING.toString())
                            .build()
            );

            System.out.println("Sample Orders Loaded");
        }
    }
}
