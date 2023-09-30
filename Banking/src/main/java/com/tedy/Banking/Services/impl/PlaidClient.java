package com.tedy.Banking.Services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import com.tedy.Banking.DTO.AccountsBalanceGetResponseDTO;
import com.tedy.Banking.DTO.IdentityGetResponseDTO;
import com.tedy.Banking.DTO.TransactionsGetResponseDTO;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;

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

        return restTemplate.postForEntity(plaidBaseUrl + "/api/set_access_token", payload, ItemPublicTokenExchangeResponse.class);
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
        return restTemplate.postForEntity(plaidBaseUrl + "/api/transactions", payload, TransactionsGetResponseDTO.class);
    }

    public ResponseEntity<IdentityGetResponseDTO> getIdentity(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/identity/get", payload, IdentityGetResponseDTO.class);
    }

    // Below are the new methods based on your controller

    public ResponseEntity<Map<String, Object>> getHoldings(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/investments/holdings/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getLiabilities(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/liabilities/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getItem(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/item/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getAccounts(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/accounts/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getAssets(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/asset_report/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getTransfer(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/transfer/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getPayment(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/payment/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }

    public ResponseEntity<Map<String, Object>> getIncomeVerificationPaystubs(String accessToken) {
        Map<String, String> payload = new HashMap<>();
        payload.put("access_token", accessToken);
        return restTemplate.postForEntity(plaidBaseUrl + "/income/paystub/get", payload, (Class<Map<String, Object>>) (Class<?>) Map.class);
    }
}


