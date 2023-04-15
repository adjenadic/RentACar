package com.example.SK_Project2.NotificationService.service.impl;


import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.CanceledReservationDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.repository.NotificationRepository;
import com.example.SK_Project2.NotificationService.service.CanceledReservationNotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CanceledReservationNotificationServiceImpl implements CanceledReservationNotificationService {
    private NotificationRepository notificationRepository;
    private NotificationMapper notificationMapper;


    public CanceledReservationNotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }


    @Override
    public NotificationDto add(CanceledReservationDto canceledReservationDto) {
        Notification notification = notificationMapper.canceledReservationDtoToNotification(canceledReservationDto);

        notificationRepository.save(notification);

        return notificationMapper.notificationToNotificationDto(notification);
    }
}
