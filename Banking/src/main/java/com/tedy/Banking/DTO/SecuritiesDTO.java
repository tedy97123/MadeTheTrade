package com.tedy.Banking.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecuritiesDTO {

    private String name;

    private URI image;

    private int current_price;

    private int market_cap;

    private String market_cap_rank;

    private String full_diluted_valuation;

    private int total_volume;

    private int high_24h;

    private int low_24h;

    private String price_change24h;

    private String price_change_percentage24h;

    private String market_cap_change;

    private String market_cap_change24h;

    private int circulating_supply;

    private int max_supply;

    private String ROI;

}
