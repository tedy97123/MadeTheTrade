package com.tedy.Banking.DTO;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountsBalanceGetResponseDTO {
    private List<AccountDTO> accounts;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AccountDTO {
        private Long id;
        private String accountId;
        private String mask;
        private String name;
        private String officialName;
        private String type;
        private String subtype;
        private BalanceDTO balance;
        @CreationTimestamp
        private LocalDateTime createdAt;
        @UpdateTimestamp
        private LocalDateTime updatedAt;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BalanceDTO {
        private Long id;
        private Double available;
        private Double current;
        private Double limit;
    }
}

