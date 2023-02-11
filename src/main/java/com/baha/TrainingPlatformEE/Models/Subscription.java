package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "SubscriptionsTable")
public class Subscription extends AbstractEntity {
    @Column(name = "SubscriptionCode")
    private Long NumSub ;
    @Column(name = "StartDate")
    private Date StartDate ;
    @Column(name = "EndDate")
    private Date EndDate ;
    @Column(name = "Price")
    private Float Price ;
    //if we don't add the mapping relation , it will be an error ! it is navigation property !
    @OneToOne()
    private Skier skier ;
    private TypeSubscription typesubscription ;

}
