package com.SKP2.ClientApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String modelName;
    private String typeName;
    private String companyName;
    private Integer rentalDayPrice;
//    private boolean reserved;
//    private Date startDate;
//    private Date endDate;
}
