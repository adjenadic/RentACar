package com.example.SK_Project2.NotificationService.listener;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ReminderDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.messageHelper.MessageHelper;
import com.example.SK_Project2.NotificationService.service.EmailService;
import com.example.SK_Project2.NotificationService.service.ReminderNotificationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class RemiderNotificationListener {
    private MessageHelper messageHelper;
    private ReminderNotificationService reminderNotificationService;
    private EmailService emailService;
    private NotificationMapper notificationMapper;

    public RemiderNotificationListener(MessageHelper messageHelper, ReminderNotificationService reminderNotificationService, EmailService emailService, NotificationMapper notificationMapper) {
        this.messageHelper = messageHelper;
        this.reminderNotificationService = reminderNotificationService;
        this.emailService = emailService;
        this.notificationMapper = notificationMapper;
    }

    @JmsListener(destination = "${destination.reminderReservation}", concurrency = "5-10")
    public void reminderEmailNotification(Message message) throws JMSException {
        ReminderDto reminderDto = messageHelper.getMessage(message, ReminderDto.class);

        NotificationDto notificationDto = reminderNotificationService.add(reminderDto);

        Notification notification = notificationMapper.notificationDtoToNotification(notificationDto);
        emailService.sendSimpleMessage(notification);

    }


}
