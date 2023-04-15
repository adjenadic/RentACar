package com.example.SK_Project2.NotificationService.listener;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.ChangedPasswordDto;
import com.example.SK_Project2.NotificationService.mapper.NotificationMapper;
import com.example.SK_Project2.NotificationService.messageHelper.MessageHelper;
import com.example.SK_Project2.NotificationService.service.ChangedPasswordNotificationService;
import com.example.SK_Project2.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class ChangedPasswordNotificationListener {

    private MessageHelper messageHelper;
    private ChangedPasswordNotificationService changedPasswordNotificationService;
    private EmailService emailService;
    private NotificationMapper notificationMapper;

    public ChangedPasswordNotificationListener(MessageHelper messageHelper, ChangedPasswordNotificationService changedPasswordNotificationService,
                                               EmailService emailService, NotificationMapper notificationMapper) {
        this.messageHelper = messageHelper;
        this.changedPasswordNotificationService = changedPasswordNotificationService;
        this.emailService = emailService;
        this.notificationMapper = notificationMapper;
    }

    @JmsListener(destination = "${destination.changedPassword}", concurrency = "5-10")
    public void changedPasswordNotification(Message message) throws JMSException {
        ChangedPasswordDto changedPasswordDto = messageHelper.getMessage(message,ChangedPasswordDto.class);
        System.out.println(changedPasswordDto);

        NotificationDto notificationDto = changedPasswordNotificationService.add(changedPasswordDto);

        //send email
        Notification notification = notificationMapper.notificationDtoToNotification(notificationDto);
        emailService.sendSimpleMessage(notification);

    }


}
