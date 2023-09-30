package com.tedy.Banking.DTO;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionsGetResponseDTO {
    private List<TransactionDTO> transactions;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class TransactionDTO {
        private Long id;
        private String transactionId;
        private String accountId;
        private Double amount;
        private String date;
        private String name;
        private List<String> categories;
        private String merchantName;
        private LocationDTO location;
        private String Description;
        private String Type;

    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LocationDTO {
        private Long id;
        private String address;
        private String city;
        private String region;
        private String postalCode;
        private String country;
        private Double lat;
        private Double lon;
        private String Description;
        private String Type;
    }
}
