package com.tedy.Banking.Services.impl;

import com.tedy.Banking.DTO.AccountsBalanceGetResponseDTO;
import com.tedy.Banking.DTO.IdentityGetResponseDTO;
import com.tedy.Banking.DTO.TransactionsGetResponseDTO;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlaidClient {

    @Value("${plaid.api.base.url}")
    private String plaidBaseUrl;

    private final RestTemplate restTemplate;

    public PlaidClient() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<ItemPublicTokenExchangeResponse> exchangePublicToken(String publicToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("public_token", publicToken);

        return restTemplate.postForEntity(plaidBaseUrl + "/item/public_token/exchange", payload, ItemPublicTokenExchangeResponse.class);
    }

    public ResponseEntity<AccountsBalanceGetResponseDTO> getBalances(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);

        return restTemplate.postForEntity(plaidBaseUrl + "/accounts/balance/get", payload, AccountsBalanceGetResponseDTO.class);
    }

    public ResponseEntity<TransactionsGetResponseDTO> getTransactions(String accessToken, String startDate, String endDate) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        payload.put("start_date", startDate);
        payload.put("end_date", endDate);

        return restTemplate.postForEntity(plaidBaseUrl + "/transactions/get", payload, TransactionsGetResponseDTO.class);
    }

    public ResponseEntity<IdentityGetResponseDTO> getIdentity(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);

        return restTemplate.postForEntity(plaidBaseUrl + "/identity/get", payload, IdentityGetResponseDTO.class);
    }
}
