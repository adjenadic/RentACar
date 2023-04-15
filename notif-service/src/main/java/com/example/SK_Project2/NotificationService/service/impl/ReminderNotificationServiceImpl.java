package com.example.SK_Project2.NotificationService.service.impl;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ReminderDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.repository.NotificationRepository;
import com.example.SK_Project2.NotificationService.service.ReminderNotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ReminderNotificationServiceImpl implements ReminderNotificationService {

    private NotificationRepository notificationRepository;
    private NotificationMapper notificationMapper;

    public ReminderNotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public NotificationDto add(ReminderDto reminderDto) {
        Notification notification = notificationMapper.reminderDtoToNotification(reminderDto);

        notificationRepository.save(notification);

        return notificationMapper.notificationToNotificationDto(notification);
    }
}
