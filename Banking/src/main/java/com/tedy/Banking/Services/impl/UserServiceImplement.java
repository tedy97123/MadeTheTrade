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

@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    @Autowired
    public UserServiceImplement(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Override
    public BankResponse createAccount(UserRequest userRequest) {

        // Check if email already exists
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        // Create and save a new user
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .birthDay(userRequest.getBirthDay())
                .password(userRequest.getPassword())
                .status("ACTIVE")
                .build();

        User savedUser = userRepository.save(newUser);

        // Send account creation email
        sendAccountCreationEmail(savedUser);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(buildAccountInfo(savedUser))
                .build();
    }

    private void sendAccountCreationEmail(User savedUser) {
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("Account Creation!")
                .messageBody(
                        "Congratulations on creating a new account!" +
                                " Your account has been successfully created! " +
                                "Your welcome to enjoy our applications features.\n" +
                                "Your Account Information: \n" +
                                "Account Name: " + savedUser.getFirstName() + " " + savedUser.getLastName() + "\n" +
                                "Account Number: " + savedUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);
    }

    private AccountInfo buildAccountInfo(User savedUser) {
        return AccountInfo.builder()
                .accountBalance(savedUser.getAccountBalance())
                .accountNumber(savedUser.getAccountNumber())
                .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
                .build();
    }
}
