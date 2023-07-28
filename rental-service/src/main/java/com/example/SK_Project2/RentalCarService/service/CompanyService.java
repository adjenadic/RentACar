package com.example.SK_Project2.RentalCarService.service;

import com.example.SK_Project2.RentalCarService.dto.company.CompanyCreateDto;
import com.example.SK_Project2.RentalCarService.dto.company.CompanyDto;


import java.util.List;

public interface CompanyService {

    List<CompanyDto> findAll();

    CompanyDto findById(Long id);

    CompanyDto addCompany(CompanyCreateDto companyCreateDto);

    Boolean deleteCompany(Long id);

    CompanyDto updateCompany(CompanyDto companyDto);


    List<CompanyDto> sortCompaniesByReview();
}
