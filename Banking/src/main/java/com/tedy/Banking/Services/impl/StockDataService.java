package com.tedy.Banking.Services.impl;

import com.tedy.Banking.Entity.StockData;
import com.tedy.Banking.Repository.StockDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StockDataService {

    private final StockDataRepository stockDataRepository;

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    public StockDataService(StockDataRepository stockDataRepository) {
        this.stockDataRepository = stockDataRepository;
    }
   
    public List<StockData> getAllFinancialData() {
        return stockDataRepository.findAll();
    }

    public List<StockData> getStocksByHighestPrice() {
        return stockDataRepository.findTop5ByOrderByPriceDesc();
    }

    public List<StockData> getStocksByLowestPrice() {
        return stockDataRepository.findTop5ByOrderByPriceAsc();
    }

    public List<Map<String, Object>> getAllYahooData() {
        String sql = "SELECT * FROM banking.yahoo_data";
        return jdbcTemplate.queryForList(sql);
    }


}
