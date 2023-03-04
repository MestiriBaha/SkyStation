package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Skier;
import com.baha.TrainingPlatformEE.Models.Subscription;
import com.baha.TrainingPlatformEE.Models.TypeSubscription;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Builder
public class SubscriptionDTO {
    private Integer ID  ;


    private Long NumSub ;

    private Date StartDate ;

    private Date EndDate ;

    private Float Price ;
    //if we don't add the mapping relation , it will be an error ! it is navigation property !

    private SkierDTO skier ;
    private TypeSubscription typesubscription ;
    public static SubscriptionDTO FromEntity(Subscription subscription)
    {
        if(subscription == null ) { return null ; }
        return SubscriptionDTO.builder()
                .ID(subscription.getID())
                .NumSub(subscription.getNumSub())
                .StartDate(subscription.getStartDate())
                .EndDate(subscription.getEndDate())
                .Price(subscription.getPrice())
                //skier
                //typesubscription
                .build() ;
    }
    public static Subscription ToEntity(SubscriptionDTO subscriptiondto)
    {
        if (subscriptiondto == null) { return null ;  }
        Subscription subscription = new Subscription() ;
        subscription.setID(subscriptiondto.getID());
        subscription.setNumSub(subscriptiondto.getNumSub());
        subscription.setPrice(subscription.getPrice());
        subscription.setStartDate(subscription.getStartDate());
        subscription.setEndDate(subscription.getEndDate());
        //skier
        //typesubscription
        return subscription ;
    }

}
