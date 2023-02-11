package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address {
    private String Address1 ;
    private String Address2 ;
    private String City ;

}
