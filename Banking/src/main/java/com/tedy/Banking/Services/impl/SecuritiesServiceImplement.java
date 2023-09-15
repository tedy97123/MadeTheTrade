package com.tedy.Banking.Services.impl;


import com.tedy.Banking.DTO.SecuritiesDTO;
import com.tedy.Banking.Entity.Securities;
import com.tedy.Banking.Repository.SecuritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecuritiesServiceImplement implements SecuritiesService {

    private final SecuritiesRepository securitiesRepository;

    @Autowired
    public SecuritiesServiceImplement(SecuritiesRepository securitiesRepository) {
        this.securitiesRepository = securitiesRepository;
    }

    @Override
    public SecuritiesDTO stockUpdateStocks(SecuritiesDTO securitiesInfo){

        Securities newStock =  Securities.builder()
                .name(securitiesInfo.getName())
                .image(securitiesInfo.getImage())
                .current_price(securitiesInfo.getCurrent_price())
                .market_cap(securitiesInfo.getMarket_cap())
                .market_cap_rank(securitiesInfo.getMarket_cap_rank())
                .full_diluted_valuation(securitiesInfo.getFull_diluted_valuation())
                .total_volume(securitiesInfo.getTotal_volume())
                .high_24h(securitiesInfo.getHigh_24h())
                .low_24h(securitiesInfo.getLow_24h())
                .price_change24h(securitiesInfo.getPrice_change24h())
                .price_change_percentage24h(securitiesInfo.getPrice_change_percentage24h())
                .market_cap_change(securitiesInfo.getMarket_cap_change())
                .market_cap_change24h(securitiesInfo.getMarket_cap_change24h())
                .circulating_supply(securitiesInfo.getCirculating_supply())
                .max_supply(securitiesInfo.getMax_supply())
                .ROI(securitiesInfo.getROI())
                .build();

                 Securities savedStock = securitiesRepository.save(newStock);


       return SecuritiesDTO.builder()
               .name(savedStock.getName())
               .image(savedStock.getImage())
               .current_price(savedStock.getCurrent_price())
               .market_cap(savedStock.getMarket_cap())
               .market_cap_rank(savedStock.getMarket_cap_rank())
               .total_volume(savedStock.getTotal_volume())
               .high_24h(savedStock.getHigh_24h())
               .low_24h(savedStock.getLow_24h())
               .price_change_percentage24h(savedStock.getPrice_change_percentage24h())
               .market_cap_change24h(savedStock.getMarket_cap_change24h())
               .circulating_supply(savedStock.getCirculating_supply())
               .max_supply(savedStock.getMax_supply())
               .build();
    }


}