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

        //SetTekst
        String firstName = notification.getParametar().getFirstName();
        String lastName = notification.getParametar().getLastName();
        String link = notification.getParametar().getLink();

        notification.setText("Pozdrav " + firstName + " " + lastName + " , verifikujte email na sledecem linku " + link);

        return notification;
    }

    public Notification changedPasswordDtoToNotification(ChangedPasswordDto changedPasswordDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("CHANGED_PASSWORD").get());
        notification.setParametar(parametarMapper.changedPasswordDtoToParametar(changedPasswordDto));


        parametarRepository.save(notification.getParametar());


        //SetTekst
        String oldPassword = notification.getParametar().getOldPassword();
        String newPassword = notification.getParametar().getNewPassword();

        notification.setText("Lozinka je promenjena, stara lozinka:" + oldPassword + " , nova lozinka:" + newPassword);

        return notification;
    }


    public Notification successfulReservationDtoToNotification(SuccessfulReservationDto successfulReservationDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("SUCCESSFUL_RESERVATION").get());
        notification.setParametar(parametarMapper.successfulReservationDtoToParametar(successfulReservationDto));


        parametarRepository.save(notification.getParametar());

        //Set tekst
        String car = notification.getParametar().getCar();
        String price = notification.getParametar().getPrice();
        Date startDate = notification.getParametar().getStartDate();
        Date endDate = notification.getParametar().getEndDate();
        notification.setText("Uspesna rezervacija automobila '" + car + "'. " +
                "Ukupna cena iznosi: '" + price + ", u periodu od " + startDate + " do " + endDate);

        return notification;
    }

    public Notification canceledReservationDtoToNotification(CanceledReservationDto canceledReservationDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("CANCELED_RESERVATION").get());
        notification.setParametar(parametarMapper.canceledReservationDtoToParametar(canceledReservationDto));

        parametarRepository.save(notification.getParametar());

        //Set tekst
        String car = notification.getParametar().getCar();

        notification.setText("Uspesna otkazana rezervacija automobila '" + car + "'");

        return notification;

    }

    public Notification reminderDtoToNotification(ReminderDto reminderDto) {
        Notification notification = new Notification();

        notification.setNotificationType(notificationTypeRepository.findNotificationTypeByName("REMINDER").get());
        notification.setParametar(parametarMapper.remiderDtoToParametar(reminderDto));

        parametarRepository.save(notification.getParametar());

        //Set text
        notification.setText("Uskoro mozete da pokupite rezervaciju za automobil  " + notification.getParametar().getCar());

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
                .orElseThrow(() -> new NotFoundException(String.format("Notification with id: %d does not exists.", notificationDto.getId())));

        return notification;
    }

}
