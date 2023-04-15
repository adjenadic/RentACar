package com.SKP2.ClientApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankCreateDto {
    private String name;
    private Integer minTotalNumberOfRentCar;
    private Integer maxTotalNumberOfRentCar;
    private Integer discount;
}
