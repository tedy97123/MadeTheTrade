package com.tedy.Banking.Services.impl;

import com.tedy.Banking.DTO.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
