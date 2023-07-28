package com.example.SK_Project2.NotificationService.listener;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ActivateEmailDto;
import com.example.SK_Project2.NotificationService.dto.parametar.SuccessfulReservationDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.messageHelper.MessageHelper;
import com.example.SK_Project2.NotificationService.service.EmailService;
import com.example.SK_Project2.NotificationService.service.SuccessfulReservationNotificationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class SuccessfulReservationNotificationListener {
    private MessageHelper messageHelper;
    private SuccessfulReservationNotificationService successfulReservationNotificationService;
    private EmailService emailService;
    private NotificationMapper notificationMapper;

    public SuccessfulReservationNotificationListener(MessageHelper messageHelper, SuccessfulReservationNotificationService successfulReservationNotificationService, EmailService emailService, NotificationMapper notificationMapper) {
        this.messageHelper = messageHelper;
        this.successfulReservationNotificationService = successfulReservationNotificationService;
        this.emailService = emailService;
        this.notificationMapper = notificationMapper;
    }

    @JmsListener(destination = "${destination.successfulReservation}", concurrency = "5-10")
    public void successfulReservationNotification(Message message) throws JMSException {
        SuccessfulReservationDto successfulReservationDto = messageHelper.getMessage(message, SuccessfulReservationDto.class);

        NotificationDto notificationDto = successfulReservationNotificationService.add(successfulReservationDto);

        Notification notification = notificationMapper.notificationDtoToNotification(notificationDto);
        emailService.sendSimpleMessage(notification);

    }
}
