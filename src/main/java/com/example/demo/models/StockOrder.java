package com.example.demo.models;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(name = "stockOrder")
public class StockOrder {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    int id;

    @Column
    String tickerName;

    @Column(nullable = true)
    double maxBuyPrice;

    @Column(nullable = true)
    double minSellPrice;

    @Column
    String type;

    @Column
    String status;
    
    @UpdateTimestamp
    Timestamp lastModified;
}
