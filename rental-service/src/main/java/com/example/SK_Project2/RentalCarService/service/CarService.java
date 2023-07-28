package com.example.SK_Project2.RentalCarService.service;

import com.example.SK_Project2.RentalCarService.dto.car.CarCreateDto;
import com.example.SK_Project2.RentalCarService.dto.car.CarDto;
import com.example.SK_Project2.RentalCarService.dto.car.CarFilterDto;

import java.util.Date;
import java.util.List;

public interface CarService {
    CarDto addCar(CarCreateDto carCreateDto);

    Boolean deleteCar(Long id);

    CarDto updateCar(CarDto carDto);

    //------------------//

    List<CarDto> findAll();

    CarDto findById(Long id);

    List<CarDto> findCarFilter(CarFilterDto carFilterDto);

    List<CarDto> sortByDayPriceASC();

    List<CarDto> sortByDayPriceDESC();


}
