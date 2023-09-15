package com.tedy.Banking.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {

    private String accountName;

    private BigDecimal accountBalance;

    private String accountNumber;


}
