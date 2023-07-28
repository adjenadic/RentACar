package com.example.SK_Project2.NotificationService.controller;

import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeCreateDto;
import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeDto;
import com.example.SK_Project2.NotificationService.security.CheckSecurity;
import com.example.SK_Project2.NotificationService.service.NotificationTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications/notification-type")
public class NotificationTypeController {
    private NotificationTypeService notificationTypeService;

    public NotificationTypeController(NotificationTypeService notificationTypeService) {
        this.notificationTypeService = notificationTypeService;
    }

    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<List<NotificationTypeDto>> getAllNotificationTypes(@RequestHeader("authorization") String authorization) {
        return new ResponseEntity<>(notificationTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<NotificationTypeDto> getNotificationTypeById(@RequestHeader("authorization") String authorization, @PathVariable("id") Long id) {
        return new ResponseEntity<>(notificationTypeService.findById(id), HttpStatus.OK);
    }
    //---------------------

    @PostMapping("/registration")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<NotificationTypeDto> registerNotificationType(@RequestHeader("authorization") String authorization, @RequestBody NotificationTypeCreateDto notificationTypeCreateDto) {
        return new ResponseEntity<>(notificationTypeService.add(notificationTypeCreateDto), HttpStatus.CREATED);
    }
    //---------------------

    @DeleteMapping("/{id}")
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<Boolean> deleteNotificationType(@RequestHeader("authorization") String authorization, @PathVariable("id") Long id) {
        return new ResponseEntity<>(notificationTypeService.delete(id), HttpStatus.OK);
    }
    //---------------------

    @PutMapping
    @CheckSecurity(roles = {"ROLE_ADMIN"})
    public ResponseEntity<NotificationTypeDto> updateNotificationType(@RequestHeader("authorization") String authorization, @RequestBody NotificationTypeDto notificationTypeDto) {
        return new ResponseEntity<>(notificationTypeService.update(notificationTypeDto), HttpStatus.OK);
    }


}
