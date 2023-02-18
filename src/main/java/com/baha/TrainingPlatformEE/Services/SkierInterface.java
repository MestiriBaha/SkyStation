package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;

import java.util.List;

public interface SkierInterface {

    SkierDTO Save (SkierDTO skierdto) ;
    SkierDTO findById (Integer id) ;
    SkierDTO findByNum (Long Num) ;

    List<SkierDTO> findAll() ;

    void Delete (Integer id)  ;


}
