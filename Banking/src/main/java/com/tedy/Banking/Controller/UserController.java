package com.tedy.Banking.Controller;


import com.tedy.Banking.DTO.BankResponse;
import com.tedy.Banking.DTO.UserRequest;
import com.tedy.Banking.Services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
     UserService userService;

    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
            return userService.createAccount(userRequest);
    }



    
    
}
