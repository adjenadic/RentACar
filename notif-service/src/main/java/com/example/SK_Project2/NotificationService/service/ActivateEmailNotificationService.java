package com.example.SK_Project2.NotificationService.service;


import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ActivateEmailDto;

public interface ActivateEmailNotificationService {

    NotificationDto add(ActivateEmailDto activateEmailDto); //zove listener ovu metodu

}
