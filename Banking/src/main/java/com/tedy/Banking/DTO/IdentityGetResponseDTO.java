package com.tedy.Banking.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class IdentityGetResponseDTO {
    private List<ItemDTO> items;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ItemDTO {
        private Long id;
        private List<AccountWithOwnersDTO> accounts;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AccountWithOwnersDTO {
        private Long id;
        private String accountId;
        private List<OwnerDTO> owners;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OwnerDTO {
        private Long id;
        private List<String> names;
        private List<AddressDTO> addresses;
        private List<String> emails;
        private List<String> phoneNumbers;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AddressDTO {
        private Long id;
        private String street;
        private String city;
        private String region;
        private String postalCode;
        private String country;
    }
}
