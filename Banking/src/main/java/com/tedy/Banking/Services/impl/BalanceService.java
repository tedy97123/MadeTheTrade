package com.tedy.Banking.Services.impl;

import com.tedy.Banking.Entity.Balance;
import com.tedy.Banking.Repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    public Balance saveBalance(Balance balance) {
        return balanceRepository.save(balance);
    }

    public Optional<Balance> getBalance(Long id) {
        return balanceRepository.findById(id);
    }

    public List<Balance> getAllBalances() {
        return balanceRepository.findAll();
    }

    public void deleteBalance(Long id) {
        balanceRepository.deleteById(id);
    }

    // Additional CRUD and utility methods
}
