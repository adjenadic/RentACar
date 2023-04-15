package com.example.SK_Project2.NotificationService.dto.notificationType;

import javax.validation.constraints.NotBlank;

public class NotificationTypeCreateDto {

    @NotBlank
    private String name;

    public NotificationTypeCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
