package com.example.SK_Project2.NotificationService.service.impl;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.domain.Parametar;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ActivateEmailDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.mapper.ParametarMapper;
import com.example.SK_Project2.NotificationService.repository.NotificationRepository;
import com.example.SK_Project2.NotificationService.repository.ParametarRepository;
import com.example.SK_Project2.NotificationService.service.ActivateEmailNotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivateEmailNotificationServiceImpl implements ActivateEmailNotificationService {

    private NotificationRepository notificationRepository;
    private NotificationMapper notificationMapper;


    public ActivateEmailNotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public NotificationDto add(ActivateEmailDto activateEmailDto) {
        Notification notification = notificationMapper.activateEmailDtoToNotification(activateEmailDto);

        notificationRepository.save(notification);

        return notificationMapper.notificationToNotificationDto(notification);
    }
}
