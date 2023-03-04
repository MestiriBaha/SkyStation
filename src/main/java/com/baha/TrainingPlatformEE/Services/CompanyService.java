package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO Save (CompanyDTO companyDTO) ;
    CompanyDTO findBycompanyName (String companyName ) ;
    List<CompanyDTO> findAll() ;

    void Delete (String companyName)  ;
}
