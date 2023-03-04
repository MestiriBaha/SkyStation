package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.PisteDTO;

import java.util.List;

public interface PisteService {

    PisteDTO Save (PisteDTO pisteDTO) ;
    PisteDTO findByPisteNum (Long PisteNum) ;
    List<PisteDTO> findAll() ;

    void Delete (Long PisteNum)  ;
}
