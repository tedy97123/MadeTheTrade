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
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<AccountWithOwners> accounts;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table(name = "account_with_owners")
    public static class AccountWithOwners {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "account_id")
        private String accountId;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountWithOwners")
        private List<Owner> owners;

        @ManyToOne
        @JoinColumn(name = "item_id")
        private Item item;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table(name = "owners")
    public static class Owner {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ElementCollection
        private List<String> names;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
        private List<Address> addresses;

        @ElementCollection
        private List<String> emails;

        @ElementCollection
        private List<String> phoneNumbers;

        @ManyToOne
        @JoinColumn(name = "account_with_owners_id")
        private AccountWithOwners accountWithOwners;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Entity
    @Table(name = "addresses")
    public static class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String street;
        private String city;
        private String region;
        private String postalCode;
        private String country;

        @ManyToOne
        @JoinColumn(name = "owner_id")
        private Owner owner;
    }
}
