package com.example.SK_Project2.NotificationService.service;

import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeCreateDto;
import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeDto;

import java.util.List;

public interface NotificationTypeService {

    NotificationTypeDto findById(Long id);

    List<NotificationTypeDto> findAll();

    NotificationTypeDto add(NotificationTypeCreateDto notificationTypeCreateDto);

    Boolean delete(Long id);

    NotificationTypeDto update(NotificationTypeDto notificationTypeDto);
}
