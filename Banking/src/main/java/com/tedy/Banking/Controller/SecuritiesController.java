package com.tedy.Banking.Controller;

import com.tedy.Banking.DTO.SecuritiesDTO;
import com.tedy.Banking.Services.impl.SecuritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/securities")
public class  SecuritiesController {

    @Autowired
    private SecuritiesService securitiesService;

    @PostMapping
    public SecuritiesDTO updateSecurities(@RequestBody SecuritiesDTO apiResponse) {
        return securitiesService.stockUpdateStocks(apiResponse);
    }
}
