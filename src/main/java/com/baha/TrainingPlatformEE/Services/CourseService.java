package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO Save (CourseDTO courseDTO) ;
    CourseDTO findByPisteNum (Long courseNum) ;
    List<CourseDTO> findAll() ;

        void Delete (Long courseNum)  ;
}
