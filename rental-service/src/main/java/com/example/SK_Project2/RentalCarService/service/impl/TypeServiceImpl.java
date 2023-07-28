package com.example.SK_Project2.RentalCarService.service.impl;

import com.example.SK_Project2.RentalCarService.domain.Type;
import com.example.SK_Project2.RentalCarService.dto.type.TypeCreateDto;
import com.example.SK_Project2.RentalCarService.dto.type.TypeDto;
import com.example.SK_Project2.RentalCarService.exception.NotFoundException;
import com.example.SK_Project2.RentalCarService.mapper.TypeMapper;
import com.example.SK_Project2.RentalCarService.repository.TypeRepository;
import com.example.SK_Project2.RentalCarService.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
    private TypeRepository typeRepository;
    private TypeMapper typeMapper;

    public TypeServiceImpl(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<TypeDto> findAll() {
        List<TypeDto> types = new ArrayList<>();
        typeRepository.findAll()
                .forEach(type -> {
                    types.add(typeMapper.typeToTypeDto(type));
                });
        return types;
    }

    @Override
    public TypeDto findById(Long id) {
        return typeRepository.findById(id)
                .map(typeMapper::typeToTypeDto)
                .orElseThrow(() -> new NotFoundException(String.format("Type with ID: %d does not exist.", id)));
    }

    @Override
    public TypeDto addType(TypeCreateDto typeCreateDto) {
        Type type = typeMapper.typeCreateDtoToType(typeCreateDto);
        typeRepository.save(type);

        return typeMapper.typeToTypeDto(type);
    }

    @Override
    public Boolean deleteType(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Type with ID: %d does not exist.", id)));

        typeRepository.delete(type);
        return true;
    }

    @Override
    public TypeDto updateType(TypeDto typeDto) {
        Type type = typeRepository.findById(typeDto.getId())
                .orElseThrow(() -> new NotFoundException(String.format("Type with ID: %d does not exist.", typeDto.getId())));

        type.setId(typeDto.getId());
        type.setName(typeDto.getName());

        typeRepository.save(type);

        return typeMapper.typeToTypeDto(type);
    }
}
