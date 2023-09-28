package com.tedy.Banking.Repository;


import com.tedy.Banking.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Additional custom query methods (if needed) can be added here.
}
