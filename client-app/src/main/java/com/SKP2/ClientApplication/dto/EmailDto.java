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
public class EmailDto {
    private String subject;
    private String context;
    private String emailFrom;
    private String emailTo;
    private Date date;
}
