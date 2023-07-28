package com.example.SK_Project2.RentalCarService.service;

import com.example.SK_Project2.RentalCarService.dto.type.TypeCreateDto;
import com.example.SK_Project2.RentalCarService.dto.type.TypeDto;

import java.util.List;

public interface TypeService {

    List<TypeDto> findAll();

    TypeDto findById(Long id);

    TypeDto addType(TypeCreateDto typeCreateDto);

    Boolean deleteType(Long id);

    TypeDto updateType(TypeDto typeDto);
}
