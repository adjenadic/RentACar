package com.example.SK_Project2.NotificationService.service.impl;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.SuccessfulReservationDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.repository.NotificationRepository;
import com.example.SK_Project2.NotificationService.service.SuccessfulReservationNotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SuccessfulReservationNotificationServiceImpl implements SuccessfulReservationNotificationService {
    private NotificationRepository notificationRepository;
    private NotificationMapper notificationMapper;


    public SuccessfulReservationNotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public NotificationDto add(SuccessfulReservationDto successfulReservationDto) {
        Notification notification = notificationMapper.successfulReservationDtoToNotification(successfulReservationDto);

        notificationRepository.save(notification);

        return notificationMapper.notificationToNotificationDto(notification);
    }
}
