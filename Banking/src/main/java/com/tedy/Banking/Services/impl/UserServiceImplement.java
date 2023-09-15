package com.tedy.Banking.Services.impl;

import com.tedy.Banking.DTO.AccountInfo;
import com.tedy.Banking.DTO.BankResponse;
import com.tedy.Banking.DTO.EmailDetails;
import com.tedy.Banking.DTO.UserRequest;
import com.tedy.Banking.Entity.User;
import com.tedy.Banking.Repository.UserRepository;
import com.tedy.Banking.Utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

import static com.tedy.Banking.Utils.AccountUtils.ACCOUNT_CREATION_MESSAGE;
import static com.tedy.Banking.Utils.AccountUtils.ACCOUNT_CREATION_SUCCESS;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public BankResponse createAccount(UserRequest userRequest)
    {

        /**
         * validation for userObject
         */
        if(userRepository.existsByEmail(userRequest.getEmail()))
        {
            return
                    BankResponse.builder()
                             .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                             .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                             .accountInfo(null)
                    .build();
        };

        /**
         * Creating an account - saving a new user into the DB
         * instantiates a new user
         * Builder Pattern
         */

        User newUser = User.builder()
                    //.userName(userRequest.getUserName())
                    .firstName(userRequest.getFirstName())
                    .lastName(userRequest.getLastName())
                    .email(userRequest.getEmail())
                   // .phoneNumber(userRequest.getPhoneNumber())
                   // .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                    .gender(userRequest.getGender())
                    //.country(userRequest.getCountry())
                    //.state(userRequest.getState())
                    .address(userRequest.getAddress())
                    .birthDay(userRequest.getBirthDay())
                    .password(userRequest.getPassword())
                    //.accountNumber(AccountUtils.generateAccountNumber())
                    //.accountBalance(BigDecimal.ZERO)
                    .status("ACTIVE")
                    .build();

        User savedUser = userRepository.save(newUser);
        //Send email alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("Account Creation!")
                .messageBody(
                        "Congratulations on creating a new account!" +
                        " Your account has been successfully created! " +
                        "Your welcome to enjoy our applications features.\n" +
                                "Your Account Information: \n" +
                        "Account Name:" + savedUser.getFirstName() + ""
                                + savedUser.getLastName() + " \n" +
                        "Account Number:" + savedUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);

        return BankResponse.builder()
                .responseCode(ACCOUNT_CREATION_SUCCESS)
                .responseMessage(ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                                .accountBalance(savedUser.getAccountBalance())
                                .accountNumber(savedUser.getAccountNumber())
                               .accountName(savedUser.getFirstName() + savedUser.getLastName())
                . build()
                )
                .build();
    }


}
