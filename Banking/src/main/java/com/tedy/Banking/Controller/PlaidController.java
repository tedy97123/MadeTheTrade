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
}
