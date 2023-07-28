package com.example.SK_Project2.NotificationService.listener;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ActivateEmailDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.messageHelper.MessageHelper;
import com.example.SK_Project2.NotificationService.service.ActivateEmailNotificationService;
import com.example.SK_Project2.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class ActivateEmailNotificationListener {

    private MessageHelper messageHelper;
    private ActivateEmailNotificationService activateEmailNotificationService;
    private EmailService emailService;
    private NotificationMapper notificationMapper;

    public ActivateEmailNotificationListener(MessageHelper messageHelper, ActivateEmailNotificationService activateEmailNotificationService,
                                             EmailService emailService, NotificationMapper notificationMapper) {
        this.messageHelper = messageHelper;
        this.activateEmailNotificationService = activateEmailNotificationService;
        this.emailService = emailService;
        this.notificationMapper = notificationMapper;
    }

    @JmsListener(destination = "${destination.activateEmail}", concurrency = "5-10")
    public void activateEmailNotification(Message message) throws JMSException {
        ActivateEmailDto activateEmailDto = messageHelper.getMessage(message, ActivateEmailDto.class);
        System.out.println(activateEmailDto);

        NotificationDto notificationDto = activateEmailNotificationService.add(activateEmailDto);

        //send email
        Notification notification = notificationMapper.notificationDtoToNotification(notificationDto);
        emailService.sendSimpleMessage(notification);

    }
}
