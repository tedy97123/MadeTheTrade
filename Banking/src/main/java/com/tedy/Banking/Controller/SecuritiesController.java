package com.tedy.Banking.Controller;

import com.tedy.Banking.DTO.SecuritiesDTO;
import com.tedy.Banking.Entity.Securities;
import com.tedy.Banking.Repository.SecuritiesRepository;
import com.tedy.Banking.Services.impl.SecuritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/securities")
public class  SecuritiesController {

    @Autowired
    private SecuritiesService securitiesService;

    @Autowired
    SecuritiesRepository securitiesRepository;

    @PostMapping
    public SecuritiesDTO updateSecurities(@RequestBody SecuritiesDTO apiResponse) {
        return securitiesService.stockUpdateStocks(apiResponse);
    }

    @GetMapping("/practice")
    public ResponseEntity<List<Securities>> getAllStocks(){
        return ResponseEntity.ok(securitiesRepository.findAll());
    }


}
