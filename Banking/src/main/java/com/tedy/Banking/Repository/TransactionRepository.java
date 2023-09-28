package com.tedy.Banking.Repository;

import com.tedy.Banking.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    // Additional custom query methods (if needed) can be added here.
}