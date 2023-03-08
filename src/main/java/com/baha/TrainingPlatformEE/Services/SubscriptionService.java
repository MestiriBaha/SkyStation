package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.SubscriptionDTO;
import com.baha.TrainingPlatformEE.Models.Subscription;
import com.baha.TrainingPlatformEE.Models.TypeSubscription;
import com.baha.TrainingPlatformEE.Services.Implementations.SubscriptionServiceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface SubscriptionService {
    SubscriptionDTO Save (SubscriptionDTO subscriptionDTO) ;
    SubscriptionDTO findByNumSub (Long NumSubscription) ;
    List<SubscriptionDTO> findByStartDate (LocalDate SubscriptionStartDate) ;

    List<SubscriptionDTO> findAll() ;

    void Delete (Long NumSubscription)  ;
    //Advanced Methods :

    List<SubscriptionDTO> retrieveSubscriptionsByDate(LocalDate startDate , LocalDate endDate) ;

     //void retrieveSubscriptions() ;
    Set<SubscriptionDTO> getSubscriptionByType(TypeSubscription type) ;

}
