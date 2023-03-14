package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Models.Skier;
import com.baha.TrainingPlatformEE.Models.TypeSubscription;

import java.util.List;

public interface SkierService {

    SkierDTO Save (SkierDTO skierdto) ;
    SkierDTO findBySkierNum (Long skierNum) ;

    List<SkierDTO> findAll() ;

    void Delete (Long skierNum)  ;

    List<SkierDTO> retrieveSkiersBySubscriptionType(TypeSubscription subscription) ;



}
