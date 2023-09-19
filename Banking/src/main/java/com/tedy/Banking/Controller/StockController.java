package com.tedy.Banking.Controller;

import com.tedy.Banking.Entity.StockData;
import com.tedy.Banking.Services.impl.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockDataService stockDataService;

    @Autowired
    public StockController(StockDataService stockDataService) {
        this.stockDataService = stockDataService;
    }

    /**
     * Endpoint to retrieve all stocks.
     *
     * @return ResponseEntity containing a list of StockData.
     */
    @GetMapping("/all")
    public ResponseEntity<List<StockData>> getAllStocks() {
        List<StockData> allStocks = stockDataService.getAllFinancialData();
        return ResponseEntity.ok(allStocks);
    }

    /**
     * Endpoint to retrieve the top 5 stocks by highest price.
     *
     * @return ResponseEntity containing a list of StockData.
     */
    @GetMapping("/highest-price")
    public ResponseEntity<List<StockData>> getStocksByHighestPrice() {
        List<StockData> stocksByHighestPrice = stockDataService.getStocksByHighestPrice();
        return ResponseEntity.ok(stocksByHighestPrice);
    }

    /**
     * Endpoint to retrieve the top 5 stocks by lowest price.
     *
     * @return ResponseEntity containing a list of StockData.
     */
    @GetMapping("/lowest-price")
    public ResponseEntity<List<StockData>> getStocksByLowestPrice() {
        List<StockData> stocksByLowestPrice = stockDataService.getStocksByLowestPrice();
        return ResponseEntity.ok(stocksByLowestPrice);
    }

    /**
     * Endpoint to retrieve all data from the yahoo_data table as a list of maps.
     *
     * @return ResponseEntity containing a list of maps representing Yahoo data.
     */
    @GetMapping("/yahoo-data/all")
    public ResponseEntity<List<Map<String, Object>>> getAllYahooData() {
        List<Map<String, Object>> yahooData = stockDataService.getAllYahooData();
        return ResponseEntity.ok(yahooData);
    }
}
