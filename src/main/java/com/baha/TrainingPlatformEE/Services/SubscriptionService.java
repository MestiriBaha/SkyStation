package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.SubscriptionDTO;
import com.baha.TrainingPlatformEE.Services.Implementations.SubscriptionServiceImpl;

import java.util.Date;
import java.util.List;

public interface SubscriptionService {
    SubscriptionDTO Save (SubscriptionDTO subscriptionDTO) ;
    SubscriptionDTO findByNumSub (Long NumSubscription) ;
    List<SubscriptionDTO> findByStartDate (Date SubscriptionStartDate) ;

    List<SubscriptionDTO> findAll() ;

    void Delete (Long NumSubscription)  ;
}
