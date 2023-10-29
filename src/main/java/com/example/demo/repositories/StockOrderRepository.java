package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.StockOrder;

@Repository
public interface StockOrderRepository extends CrudRepository<StockOrder, Long>, PagingAndSortingRepository<StockOrder,Long>{
    
    @Query("SELECT s FROM StockOrder AS s WHERE s.status = :status ORDER BY s.lastModified ASC")
    List<StockOrder> findByStatus(@Param("status") String status);

    @Query("SELECT s FROM StockOrder AS s WHERE s.status = :status AND s.type = :type ORDER BY s.lastModified ASC")
    List<StockOrder> findBytype(@Param("status") String status, @Param("type") String type);

    @Query("SELECT a FROM StockOrder AS a WHERE a.status = :status AND a.tickerName = :ticker AND a.type = :type AND a.minSellPrice <= :maxBuyPrice ORDER BY a.lastModified ASC")
    List<StockOrder> findBuyMatch(@Param("status") String status, @Param("ticker") String ticker, @Param("type") String type, @Param("maxBuyPrice") double price);

    @Query("SELECT a FROM StockOrder AS a WHERE a.status = :status AND a.tickerName = :ticker AND a.type = :type AND a.maxBuyPrice >= :minSellPrice ORDER BY a.lastModified ASC")
    List<StockOrder> findSellMatch(@Param("status") String status, @Param("ticker") String ticker, @Param("type") String type, @Param("minSellPrice") double price);

    @Modifying
    @Transactional
    @Query("UPDATE StockOrder AS a SET a.status = :status WHERE a.id = :stockId")
    void updateStatus(@Param("status") String status, @Param("stockId") int stockId);
}
