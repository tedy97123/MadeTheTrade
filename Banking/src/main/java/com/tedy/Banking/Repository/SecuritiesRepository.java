package com.tedy.Banking.Repository;

import com.tedy.Banking.Entity.Securities;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecuritiesRepository extends JpaRepository<Securities, Long> {
     @NotNull Optional<Securities> findById(@NotNull Long Id);
}
