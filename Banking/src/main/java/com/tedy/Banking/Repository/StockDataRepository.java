package com.tedy.Banking.Repository;

import com.tedy.Banking.Entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockDataRepository extends JpaRepository<StockData, Long> {
    // Define custom query methods if needed
    // Method to get all stock data
    List<StockData> findAll();

    // Method to get stocks by highest price (order by price descending and limit the result)
    List<StockData> findTop5ByOrderByPriceDesc();

    // Method to get stocks by lowest price (order by price ascending and limit the result)
    List<StockData> findTop5ByOrderByPriceAsc();

}
