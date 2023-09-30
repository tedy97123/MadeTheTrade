package com.tedy.Banking.Services.impl;

import com.tedy.Banking.Entity.Account;
import com.tedy.Banking.DTO.AccountsBalanceGetResponseDTO;
import com.tedy.Banking.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<AccountsBalanceGetResponseDTO.AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        // Convert to DTOs
        return accounts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AccountsBalanceGetResponseDTO.AccountDTO convertToDTO(Account account) {
        AccountsBalanceGetResponseDTO.AccountDTO accountDTO = new AccountsBalanceGetResponseDTO.AccountDTO();

        accountDTO.setId(account.getId());
        accountDTO.setName(account.getName());
        accountDTO.setBalance(convertEntityToDTO(account.getBalance())); // Use the conversion method here
        accountDTO.setType(account.getType());
        accountDTO.setCreatedAt(account.getCreatedAt());
        accountDTO.setUpdatedAt(account.getUpdatedAt());
        // ... Add other fields as needed ...

        return accountDTO;
    }

    // Conversion method for Balance entity to BalanceDTO
    private AccountsBalanceGetResponseDTO.BalanceDTO convertEntityToDTO(Account.Balance balanceEntity) {
        AccountsBalanceGetResponseDTO.BalanceDTO balanceDTO = new AccountsBalanceGetResponseDTO.BalanceDTO();

        balanceDTO.setAvailable(balanceEntity.getAvailable());
        balanceDTO.setCurrent(balanceEntity.getCurrent());
        // ... any other fields that need to be set ...

        return balanceDTO;
    }
}
