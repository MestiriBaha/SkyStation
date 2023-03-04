package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;

import java.util.List;

public interface SkierService {

    SkierDTO Save (SkierDTO skierdto) ;
    SkierDTO findBySkierNum (Long skierNum) ;

    List<SkierDTO> findAll() ;

    void Delete (Long skierNum)  ;


}
