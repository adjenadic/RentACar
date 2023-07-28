package com.example.SK_Project2.NotificationService.service.impl;

import com.example.SK_Project2.NotificationService.domain.Email;
import com.example.SK_Project2.NotificationService.domain.Notification;
import com.example.SK_Project2.NotificationService.dto.email.EmailDto;
import com.example.SK_Project2.NotificationService.dto.email.FilterEmailDto;
import com.example.SK_Project2.NotificationService.exception.NotFoundException;
import com.example.SK_Project2.NotificationService.mapper.EmailMapper;
import com.example.SK_Project2.NotificationService.repository.EmailRepository;
import com.example.SK_Project2.NotificationService.security.service.TokenService;
import com.example.SK_Project2.NotificationService.service.EmailService;
import io.jsonwebtoken.Claims;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;
    private EmailRepository emailRepository;
    private EmailMapper emailMapper;
    private TokenService tokenService;

    public EmailServiceImpl(JavaMailSender mailSender, EmailRepository emailRepository, EmailMapper emailMapper, TokenService tokenService) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
        this.tokenService = tokenService;
    }

    @Override
    public void sendSimpleMessage(Notification notification) {
        Email email = new Email();
        email.setNotification(notification);
        email.setSubject(notification.getNotificationType().getName());
        email.setContext(notification.getText());
        email.setEmailFrom("skprojekat2test@gmail.com");
        email.setEmailTo(notification.getParametar().getEmail());

        Date now = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        email.setDate(now);

        emailRepository.save(email);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getContext());
        mailSender.send(message);
    }

    @Override
    public List<EmailDto> findAllEmails(String authorization) {
        Claims claims = tokenService.parseToken(authorization.split(" ")[1]);
        String roleName = claims.get("role", String.class);
        String userEmail = claims.get("email", String.class);

        List<EmailDto> emailsList = new ArrayList<>();

        if (roleName.equals("ROLE_ADMIN")) {
            emailRepository.findAll().forEach(email -> {
                emailsList.add(emailMapper.emailToEmailDto(email));
            });
        } else if (roleName.equals("ROLE_MANAGER")) {
            emailRepository.findAll().forEach(email -> {
                if (email.getEmailTo().equals(userEmail)) {
                    emailsList.add(emailMapper.emailToEmailDto(email));
                }
            });
        } else {
            emailRepository.findAll().forEach(email -> {
                if (email.getEmailTo().equals(userEmail)) {
                    emailsList.add(emailMapper.emailToEmailDto(email));
                }
            });
        }
        return emailsList;
    }


    @Override
    public List<EmailDto> filterEmail(String authorization, FilterEmailDto filterEmailDto) {
        List<EmailDto> allEmails = findAllEmails(authorization);

        List<EmailDto> filterEmails = new ArrayList<>();

        for (EmailDto emailDto : allEmails) {
            Date date = emailDto.getDate();
            if (emailDto.getEmailTo().equals(filterEmailDto.getEmail()) && emailDto.getSubject().equals(filterEmailDto.getSubject())
                    && filterEmailDto.getStartDate().before(date) && filterEmailDto.getEndDate().after(date)) {
                filterEmails.add(emailDto);
            }

        }

        return filterEmails;
    }
}
