package com.example.SK_Project2.NotificationService.service;

import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ChangedPasswordDto;

public interface ChangedPasswordNotificationService {

    NotificationDto add(ChangedPasswordDto changedPasswordDto);

}
