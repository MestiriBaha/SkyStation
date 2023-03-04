package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.RegistrationDTO;

import java.util.List;

public interface RegistrationService {
    RegistrationDTO Save (RegistrationDTO registrationDTO) ;
    RegistrationDTO findByRegistrationNum (Long registrationNum) ;
    List<RegistrationDTO> findAll() ;

    void Delete (Long registrationNum)  ;
}
