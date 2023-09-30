package com.tedy.Banking.Controller;

import com.tedy.Banking.DTO.AccountsBalanceGetResponseDTO;
import com.tedy.Banking.DTO.IdentityGetResponseDTO;
import com.tedy.Banking.DTO.TransactionsGetResponseDTO;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import com.tedy.Banking.Services.impl.PlaidClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/plaid")
public class PlaidController {

    private final PlaidClient plaidClient;

    @Autowired
    public PlaidController(PlaidClient plaidClient) {
        this.plaidClient = plaidClient;
    }

    @PostMapping("/exchange-token")
    public ResponseEntity<?> exchangeToken(@RequestBody String publicToken) {
        try {
            ResponseEntity<ItemPublicTokenExchangeResponse> response = plaidClient.exchangePublicToken(publicToken);

            if (response.getStatusCode() == HttpStatus.OK) {
                String accessToken = response.getBody().getAccessToken();
                // Save accessToken to your database and handle accordingly
                return ResponseEntity.ok(accessToken);
            } else {
                // Handle Plaid errors
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/hello")
    public String helloworld() {
        return "Hello";

    }
    @PostMapping("/get-balances")
    public ResponseEntity<?> getBalances(@RequestParam String accessToken) {
        try {
            ResponseEntity<AccountsBalanceGetResponseDTO> response = plaidClient.getBalances(accessToken);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(response.getBody());
            } else {
                // Handle Plaid errors
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/get-transactions")
    public ResponseEntity<?> getTransactions(
            @RequestParam String accessToken,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        try {
            ResponseEntity<TransactionsGetResponseDTO> response = plaidClient.getTransactions(accessToken, startDate, endDate);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(response.getBody());
            } else {
                // Handle Plaid errors
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/get-identity")
    public ResponseEntity<?> getIdentity(@RequestParam String accessToken) {
        try {
            ResponseEntity<IdentityGetResponseDTO> response = plaidClient.getIdentity(accessToken);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(response.getBody());
            } else {
                // Handle Plaid errors
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get-holdings")
    public ResponseEntity<?> getHoldings(String accessToken) {
        return handleResponse(plaidClient.getHoldings(accessToken));
    }

    @GetMapping("/get-liabilities")
    public ResponseEntity<?> getLiabilities (String accessToken) {
        return handleResponse(plaidClient.getLiabilities(accessToken));
    }

    @GetMapping("/get-item")
    public ResponseEntity<?> getItem(String accessToken) {
        return handleResponse(plaidClient.getItem(accessToken));
    }

    @GetMapping("/get-accounts")
    public ResponseEntity<?> getAccounts(String accessToken) {
        return handleResponse(plaidClient.getAccounts(accessToken));
    }

    @GetMapping("/get-assets")
    public ResponseEntity<?> getAssets(String accessToken) {
        return handleResponse(plaidClient.getAssets(accessToken));
    }

    @GetMapping("/get-transfer")
    public ResponseEntity<?> getTransfer(String accessToken) {
        return handleResponse(plaidClient.getTransfer(accessToken));
    }

    @GetMapping("/get-payment")
    public ResponseEntity<?> getPayment(String accessToken) {
        return handleResponse(plaidClient.getPayment(accessToken));
    }

    @GetMapping("/get-income-verification-paystubs")
    public ResponseEntity<?> getIncomeVerificationPaystubs(String accessToken) {
        return handleResponse(plaidClient.getIncomeVerificationPaystubs(accessToken));
    }

    private ResponseEntity<?> handleResponse(ResponseEntity<Map<String, Object>> responseEntity) {
        if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(responseEntity.getBody());
        } else {
            // This is a general way to handle any potential error response. Adjust as needed.
            return (responseEntity != null)
                    ? ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody())
                    : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve data.");
        }
    }

}
