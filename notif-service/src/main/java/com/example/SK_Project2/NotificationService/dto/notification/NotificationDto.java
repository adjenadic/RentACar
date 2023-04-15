package com.example.SK_Project2.NotificationService.dto.notification;

public class NotificationDto {
    private Long id;
    private String text;

    public NotificationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
