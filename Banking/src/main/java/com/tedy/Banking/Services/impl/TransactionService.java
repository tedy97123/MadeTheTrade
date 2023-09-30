package com.tedy.Banking.Services.impl;

import com.tedy.Banking.Entity.Transactions;
import com.tedy.Banking.DTO.TransactionsGetResponseDTO;
import com.tedy.Banking.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional(readOnly = true)
    public List<TransactionsGetResponseDTO.TransactionDTO> getAllTransactions() {
        List<Transactions> transactions = transactionRepository.findAll();

        // Convert to DTOs
        return transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TransactionsGetResponseDTO.TransactionDTO convertToDTO(Transactions transaction) {
        TransactionsGetResponseDTO.TransactionDTO transactionDTO = new TransactionsGetResponseDTO.TransactionDTO();

        transactionDTO.setId(transaction.getId());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setType(transaction.getType());
        transactionDTO.setAccountId(transaction.getAccountId());
        // ... Add other fields as needed ...

        return transactionDTO;
    }
}
