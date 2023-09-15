package com.tedy.Banking.Services.impl;

import com.tedy.Banking.DTO.BankResponse;
import com.tedy.Banking.DTO.UserRequest;

public interface UserService {

    BankResponse createAccount(UserRequest userRequest);
}
