package com.SKP2.ClientApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;
    private Long userId;
    private Long carId;
    private String carName;
    private Date startDate;
    private Date endDate;
    private Integer totalPrice;
    private String email;
}
