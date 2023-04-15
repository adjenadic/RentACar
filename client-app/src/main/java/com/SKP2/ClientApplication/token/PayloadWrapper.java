package com.SKP2.ClientApplication.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayloadWrapper {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;
    private String dayOfBirth;
    private String firstName;
    private String lastName;
    private boolean forbidden;
}
