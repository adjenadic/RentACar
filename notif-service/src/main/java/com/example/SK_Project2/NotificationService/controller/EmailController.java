package com.example.SK_Project2.NotificationService.controller;

import com.example.SK_Project2.NotificationService.dto.email.EmailDto;
import com.example.SK_Project2.NotificationService.dto.email.FilterEmailDto;
import com.example.SK_Project2.NotificationService.security.CheckSecurity;
import com.example.SK_Project2.NotificationService.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications/email")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN","ROLE_MANAGER","ROLE_CLIENT"})
    public ResponseEntity<List<EmailDto>> getAllEmails(@RequestHeader("authorization") String authorization){
        return new ResponseEntity<>(emailService.findAllEmails(authorization), HttpStatus.OK);
    }

    @PutMapping("/filter")
    @CheckSecurity(roles = {"ROLE_ADMIN","ROLE_MANAGER","ROLE_CLIENT"})
    public ResponseEntity<List<EmailDto>> getFilterEmails(@RequestHeader("authorization") String authorization, @RequestBody FilterEmailDto filterEmailDto){
        return new ResponseEntity<>(emailService.filterEmail(authorization,filterEmailDto),HttpStatus.OK);
    }


}
