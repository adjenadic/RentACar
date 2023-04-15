package com.SKP2.ClientApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientCreateDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Date dayOfBirth;
    private String firstName;
    private String lastName;
    private String passport;
}
