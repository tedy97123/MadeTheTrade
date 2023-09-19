package com.tedy.Banking.Controller;

import com.tedy.Banking.DTO.SecuritiesDTO;
import com.tedy.Banking.Entity.Securities;
import com.tedy.Banking.Repository.SecuritiesRepository;
import com.tedy.Banking.Services.impl.YahooService;
import com.tedy.Banking.Utils.ExcelExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/securities")
public class SecuritiesController {

    @Autowired
    private YahooService yahooService; // Inject the YahooService

    @Autowired
    private SecuritiesRepository securitiesRepository;

    private String value;

    @PostMapping("/update-stocks")
    public ResponseEntity<String> updateSecurities(@RequestBody SecuritiesDTO apiResponse) {
        try {
            // Perform stock update logic here using SecuritiesDTO and YahooService
            // Example: securitiesService.updateStocks(apiResponse);

            // After processing, return a success response
            return ResponseEntity.ok("Stocks updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating stocks.");
        }
    }

    @GetMapping("/practice")
    public ResponseEntity<List<Securities>> getAllStocks() {
        List<Securities> securities = securitiesRepository.findAll();
        return ResponseEntity.ok(securities);
    }

    @GetMapping("/fetch-data-from-yahoo")
    public ResponseEntity<String> fetchDataFromYahoo() {
        try {
            // Call the YahooService method to fetch and insert data from Yahoo
            yahooService.fetchAndInsertDataFromYahoo(value);
            return ResponseEntity.ok("Data fetched from Yahoo and inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching data from Yahoo.");
        }
    }
}
