package com.tedy.Banking.Services.impl;

import com.tedy.Banking.DTO.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpement implements EmailService  {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(senderEmail);

            mailMessage.setTo(emailDetails.getRecipient());

            mailMessage.setText(emailDetails.getMessageBody());

            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);

            System.out.println("Mail was Successful!");

        } catch (MailException e){
            throw new RuntimeException(e);
        }
    }
}
