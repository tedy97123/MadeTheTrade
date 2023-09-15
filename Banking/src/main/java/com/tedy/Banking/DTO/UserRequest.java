package com.tedy.Banking.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String alternativePhoneNumber;

    private String gender;

    private String country;

    private String state;

    private String address;

    private Date birthDay;

    private String password;

    private String accountNumber;

}
