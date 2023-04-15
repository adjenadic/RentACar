package com.example.SK_Project2.NotificationService.mapper;

import com.example.SK_Project2.NotificationService.domain.Parametar;
import com.example.SK_Project2.NotificationService.dto.parametar.*;
import org.springframework.stereotype.Component;

@Component
public class ParametarMapper {

    public ParametarMapper() {
    }

    public Parametar activateEmailDtoToParametar(ActivateEmailDto activateEmailDto){
        Parametar parametar = new Parametar();

        parametar.setFirstName(activateEmailDto.getFirstName());
        parametar.setLastName(activateEmailDto.getLastName());
        parametar.setEmail(activateEmailDto.getEmail());
        parametar.setLink(activateEmailDto.getLink());

        parametar.setOldPassword(null);
        parametar.setNewPassword(null);
        parametar.setCar(null);
        parametar.setPrice(null);
        parametar.setStartDate(null);
        parametar.setEndDate(null);

        return parametar;
    }

    public Parametar changedPasswordDtoToParametar(ChangedPasswordDto changedPasswordDto){
        Parametar parametar = new Parametar();

        parametar.setNewPassword(changedPasswordDto.getNewPassword());
        parametar.setOldPassword(changedPasswordDto.getOldPassword());
        parametar.setEmail(changedPasswordDto.getEmail());

        parametar.setFirstName(null);
        parametar.setLastName(null);
        parametar.setLink(null);
        parametar.setCar(null);
        parametar.setPrice(null);
        parametar.setStartDate(null);
        parametar.setEndDate(null);

        return parametar;
    }

    public Parametar successfulReservationDtoToParametar(SuccessfulReservationDto successfulReservationDto){
        Parametar parametar = new Parametar();

        parametar.setEmail(successfulReservationDto.getEmail());
        parametar.setCar(successfulReservationDto.getCar());
        parametar.setPrice(successfulReservationDto.getPrice());
        parametar.setStartDate(successfulReservationDto.getStartDate());
        parametar.setEndDate(successfulReservationDto.getEndDate());

        parametar.setLink(null);
        parametar.setFirstName(null);
        parametar.setLastName(null);
        parametar.setOldPassword(null);
        parametar.setNewPassword(null);

        return parametar;
    }

    public Parametar canceledReservationDtoToParametar(CanceledReservationDto canceledReservationDto){
        Parametar parametar = new Parametar();

        parametar.setEmail(canceledReservationDto.getEmail());
        parametar.setCar(canceledReservationDto.getCar());

        parametar.setFirstName(null);
        parametar.setLastName(null);
        parametar.setOldPassword(null);
        parametar.setNewPassword(null);
        parametar.setLink(null);
        parametar.setPrice(null);
        parametar.setStartDate(null);
        parametar.setEndDate(null);

        return parametar;
    }

    public Parametar remiderDtoToParametar(ReminderDto reminderDto){
        Parametar parametar = new Parametar();

        parametar.setEmail(reminderDto.getEmail());
        parametar.setCar(reminderDto.getCar());

        parametar.setFirstName(null);
        parametar.setLastName(null);
        parametar.setOldPassword(null);
        parametar.setNewPassword(null);
        parametar.setLink(null);
        parametar.setPrice(null);
        parametar.setStartDate(null);
        parametar.setEndDate(null);

        return parametar;
    }


}
