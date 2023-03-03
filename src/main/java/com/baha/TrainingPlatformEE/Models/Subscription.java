package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "SubscriptionsTable")
public class Subscription extends AbstractEntity {
    @Column(name = "SubscriptionCode")
    @Id
    private Long NumSub ;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date StartDate ;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date EndDate ;
    @Column(name = "Price")
    private Float Price ;
    //if we don't add the mapping relation , it will be an error ! it is navigation property !
    @Enumerated(EnumType.STRING)
    private TypeSubscription typesubscription ;

}
