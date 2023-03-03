package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter


@Table(name = "SkiersTable")
public class Skier extends AbstractEntity {
    //gott it makes a huge Problem when we write NumSkier when working with JpaRepository and then services !!
    //Spring has awful conventions , as an example name FindByNumSkier won't work if we have NumSkier !
    // it is his way of properties in entities are traversed !!
    @Id
    private Long numSkier ;
    private String FirstName ;
    private String LastName ;
    @Temporal(TemporalType.DATE)
    private Date DateOfBirth ;
    @Embedded
    private Address address ;
    private String Photo ;
    @OneToOne
    private Subscription subscription ;

    @OneToMany(mappedBy = "skier")
    private List<Registration> registration ;
    @ManyToMany(mappedBy = "Skiers")
    private List<Piste> Pistes ;
}
