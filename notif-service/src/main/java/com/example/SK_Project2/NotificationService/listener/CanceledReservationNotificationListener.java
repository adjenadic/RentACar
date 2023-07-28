package com.example.SK_Project2.NotificationService.listener;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.CanceledReservationDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.messageHelper.MessageHelper;
import com.example.SK_Project2.NotificationService.service.CanceledReservationNotificationService;
import com.example.SK_Project2.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class CanceledReservationNotificationListener {

    private MessageHelper messageHelper;
    private CanceledReservationNotificationService canceledReservationNotificationService;
    private EmailService emailService;
    private NotificationMapper notificationMapper;

    public CanceledReservationNotificationListener(MessageHelper messageHelper, CanceledReservationNotificationService canceledReservationNotificationService, EmailService emailService, NotificationMapper notificationMapper) {
        this.messageHelper = messageHelper;
        this.canceledReservationNotificationService = canceledReservationNotificationService;
        this.emailService = emailService;
        this.notificationMapper = notificationMapper;
    }

    @JmsListener(destination = "${destination.canceledReservation}", concurrency = "5-10")
    public void successfulReservationNotification(Message message) throws JMSException {
        CanceledReservationDto canceledReservationDto = messageHelper.getMessage(message, CanceledReservationDto.class);

        NotificationDto notificationDto = canceledReservationNotificationService.add(canceledReservationDto);

        Notification notification = notificationMapper.notificationDtoToNotification(notificationDto);
        emailService.sendSimpleMessage(notification);
    }

}
