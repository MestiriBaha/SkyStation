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
    private Long NumSkier ;
    private String FirstName ;
    private String LastName ;
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
