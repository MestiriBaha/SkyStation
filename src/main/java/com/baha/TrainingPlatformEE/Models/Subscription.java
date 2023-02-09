package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SubscriptionsTable")
public class Subscription extends AbstractEntity {
    private Long NumSub ;
    private Date StartDate ;
    private Date EndDate ;
    private Float Price ;
    private TypeSubscription typesubscription ;

}
