package com.example.SK_Project2.NotificationService.service;

import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.SuccessfulReservationDto;

public interface SuccessfulReservationNotificationService {

    NotificationDto add(SuccessfulReservationDto successfulReservationDto);
}
