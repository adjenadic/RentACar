package com.example.SK_Project2.NotificationService.service;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.email.EmailDto;
import com.example.SK_Project2.NotificationService.dto.email.FilterEmailDto;


import java.util.List;

public interface EmailService {

    void sendSimpleMessage(Notification notification);


    List<EmailDto> findAllEmails(String authorization);

    List<EmailDto> filterEmail(String authorization, FilterEmailDto filterEmailDto);


}
