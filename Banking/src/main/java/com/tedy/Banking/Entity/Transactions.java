package com.tedy.Banking.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_id")
    private String accountId;
    private Double amount;
    private String date;
    private String name;
    private String Description;
    private String Type;

    @ElementCollection
    private List<String> categories;

    @Column(name = "merchant_name")
    private String merchantName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table(name = "locations")
    public static class Location {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String address;
        private String city;
        private String region;
        private String postalCode;
        private String country;
        private Double lat;
        private Double lon;
    }
}
