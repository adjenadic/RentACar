package com.example.SK_Project2.NotificationService.service;

import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ReminderDto;

public interface ReminderNotificationService {

    NotificationDto add(ReminderDto reminderDto); // zove listener ovu metodu

}
