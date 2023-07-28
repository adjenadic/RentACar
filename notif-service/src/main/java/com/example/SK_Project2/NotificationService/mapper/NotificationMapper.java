package com.example.SK_Project2.NotificationService.mapper;

import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.notification.NotificationDto;
import com.example.SK_Project2.NotificationService.dto.parametar.*;
import com.example.SK_Project2.NotificationService.exception.NotFoundException;
import com.example.SK_Project2.NotificationService.repository.NotificationRepository;
import com.example.SK_Project2.NotificationService.repository.NotificationTypeRepository;
import com.example.SK_Project2.NotificationService.repository.ParametarRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NotificationMapper {

    private NotificationTypeRepository notificationTypeRepository;
    private NotificationRepository notificationRepository;
    private ParametarMapper parametarMapper;
    private ParametarRepository parametarRepository;


    public NotificationMapper(NotificationTypeRepository notificationTypeRepository, NotificationRepository notificationRepository, ParametarMapper parametarMapper, ParametarRepository parametarRepository) {
        this.notificationTypeRepository = notificationTypeRepository;
        this.notificationRepository = notificationRepository;
        this.parametarMapper = parametarMapper;
        this.parametarRepository = parametarRepository;
    }

    public Notification activateEmailDtoToNotification(ActivateEmailDto activateEmailDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("ACTIVATE_EMAIL").get());
        notification.setParametar(parametarMapper.activateEmailDtoToParametar(activateEmailDto));

        parametarRepository.save(notification.getParametar());

        String firstName = notification.getParametar().getFirstName();
        String lastName = notification.getParametar().getLastName();
        String link = notification.getParametar().getLink();

        notification.setText("Hello, " + firstName + " " + lastName + " , verify your email using the following:\n" + link);

        return notification;
    }

    public Notification changedPasswordDtoToNotification(ChangedPasswordDto changedPasswordDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("CHANGED_PASSWORD").get());
        notification.setParametar(parametarMapper.changedPasswordDtoToParametar(changedPasswordDto));

        parametarRepository.save(notification.getParametar());

        String oldPassword = notification.getParametar().getOldPassword();
        String newPassword = notification.getParametar().getNewPassword();

        notification.setText("Password has been successfully changed.\nOld password: " + oldPassword + "\nNew password:" + newPassword);

        return notification;
    }


    public Notification successfulReservationDtoToNotification(SuccessfulReservationDto successfulReservationDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("SUCCESSFUL_RESERVATION").get());
        notification.setParametar(parametarMapper.successfulReservationDtoToParametar(successfulReservationDto));

        parametarRepository.save(notification.getParametar());

        String car = notification.getParametar().getCar();
        String price = notification.getParametar().getPrice();
        Date startDate = notification.getParametar().getStartDate();
        Date endDate = notification.getParametar().getEndDate();
        notification.setText("Reservation successful: '" + car + "'. " +
                "\nTotal price: '" + price + "\nDuration:" + startDate + " do " + endDate);

        return notification;
    }

    public Notification canceledReservationDtoToNotification(CanceledReservationDto canceledReservationDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("CANCELED_RESERVATION").get());
        notification.setParametar(parametarMapper.canceledReservationDtoToParametar(canceledReservationDto));

        parametarRepository.save(notification.getParametar());

        String car = notification.getParametar().getCar();

        notification.setText("Reservation cancelled: '" + car + "'");

        return notification;

    }

    public Notification reminderDtoToNotification(ReminderDto reminderDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("REMINDER").get());
        notification.setParametar(parametarMapper.remiderDtoToParametar(reminderDto));

        parametarRepository.save(notification.getParametar());

        notification.setText("Reservation available for pickup: " + notification.getParametar().getCar());

        return notification;
    }


    public NotificationDto notificationToNotificationDto(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(notification.getId());
        notificationDto.setText(notification.getText());

        return notificationDto;
    }


    public Notification notificationDtoToNotification(NotificationDto notificationDto) {
        Notification notification = notificationRepository.findNotificationById(notificationDto.getId())
                .orElseThrow(() -> new NotFoundException(String.format("Notification with ID %d does not exist.", notificationDto.getId())));

        return notification;
    }

}
