package com.example.SK_Project2.NotificationService.mapper;


import com.example.SK_Project2.NotificationService.domain.NotificationType;
import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeCreateDto;
import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationTypeMapper {

    public NotificationTypeMapper() {
    }

    public NotificationTypeDto notificationTypeToNotificationTypeDto(NotificationType notificationType) {
        NotificationTypeDto notificationTypeDto = new NotificationTypeDto();

        notificationTypeDto.setId(notificationType.getId());
        notificationTypeDto.setName(notificationType.getName());

        return notificationTypeDto;
    }

    public NotificationType notificationTypeCreateDtoToNotificationType(NotificationTypeCreateDto notificationTypeCreateDto) {
        NotificationType notificationType = new NotificationType();

        notificationType.setName(notificationTypeCreateDto.getName());

        return notificationType;
    }
}
