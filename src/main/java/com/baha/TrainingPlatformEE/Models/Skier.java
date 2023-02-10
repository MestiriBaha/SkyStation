package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Table(name = "SkiersTable")
public class Skier extends AbstractEntity {
    private Long NumSkier ;
    private String FirstName ;
    private String LastName ;
    private Date DateOfBirth ;
    @Embedded
    private Address address ;
    private String Photo ;
    @OneToOne(mappedBy = "skier")
    private Subscription subscription ;

    @OneToMany(mappedBy = "skier")
    private List<Registration> registration ;
}
