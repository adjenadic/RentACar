package com.example.SK_Project2.NotificationService.mapper;

import com.example.SK_Project2.NotificationService.domain.Email;
import com.example.SK_Project2.NotificationService.dto.email.EmailDto;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {

    public EmailMapper() {
    }


    public EmailDto emailToEmailDto(Email email){
        EmailDto emailDto = new EmailDto();
        emailDto.setSubject(email.getSubject());
        emailDto.setContext(email.getContext());
        emailDto.setEmailFrom(email.getEmailFrom());
        emailDto.setEmailTo(email.getEmailTo());
        emailDto.setDate(email.getDate());


        return emailDto;
    }
}
