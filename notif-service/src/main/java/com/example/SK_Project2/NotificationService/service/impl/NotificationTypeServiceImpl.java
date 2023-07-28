package com.example.SK_Project2.NotificationService.service.impl;

import com.example.SK_Project2.NotificationService.domain.NotificationType;
import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeCreateDto;
import com.example.SK_Project2.NotificationService.dto.notificationType.NotificationTypeDto;
import com.example.SK_Project2.NotificationService.exception.NotFoundException;
import com.example.SK_Project2.NotificationService.mapper.NotificationTypeMapper;
import com.example.SK_Project2.NotificationService.repository.NotificationTypeRepository;
import com.example.SK_Project2.NotificationService.service.NotificationTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NotificationTypeServiceImpl implements NotificationTypeService {
    private NotificationTypeRepository notificationTypeRepository;
    private NotificationTypeMapper notificationTypeMapper;


    public NotificationTypeServiceImpl(NotificationTypeRepository notificationTypeRepository, NotificationTypeMapper notificationTypeMapper) {
        this.notificationTypeRepository = notificationTypeRepository;
        this.notificationTypeMapper = notificationTypeMapper;
    }

    @Override
    public NotificationTypeDto findById(Long id) {
        return notificationTypeRepository.findById(id)
                .map(notificationTypeMapper::notificationTypeToNotificationTypeDto)
                .orElseThrow(() -> new NotFoundException(String.format("Notification Type with id: %d does not exists.", id)));

    }

    @Override
    public List<NotificationTypeDto> findAll() {
        List<NotificationTypeDto> notificationTypes = new ArrayList<>();

        notificationTypeRepository.findAll()
                .forEach(notificationType -> {
                    notificationTypes.add(notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType));
                });

        return notificationTypes;
    }

    @Override
    public NotificationTypeDto add(NotificationTypeCreateDto notificationTypeCreateDto) {
        NotificationType notificationType = notificationTypeMapper.notificationTypeCreateDtoToNotificationType(notificationTypeCreateDto);
        notificationTypeRepository.save(notificationType);

        return notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
    }

    @Override
    public Boolean delete(Long id) {
        NotificationType notificationType = notificationTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Notification Type with id: %d does not exists.", id)));

        notificationTypeRepository.delete(notificationType);
        return true;
    }

    @Override
    public NotificationTypeDto update(NotificationTypeDto notificationTypeDto) {
        NotificationType notificationType = notificationTypeRepository.findById(notificationTypeDto.getId())
                .orElseThrow(() -> new NotFoundException(String.format("Notification Type with id: %d does not exists.", notificationTypeDto.getId())));

        notificationType.setId(notificationTypeDto.getId());
        notificationType.setName(notificationTypeDto.getName());

        notificationTypeRepository.save(notificationType);

        return notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
    }
}
