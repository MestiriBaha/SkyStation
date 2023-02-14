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
    @OneToOne(mappedBy = "skier")
    private Subscription subscription ;

    @OneToMany(mappedBy = "skier")
    private List<Registration> registration ;
    @ManyToMany
    @JoinTable(name = "SkierPiste" , joinColumns = @JoinColumn(name = "student_id") , inverseJoinColumns = @JoinColumn(name = "PisteID"))
    private List<Piste> Pistes ;
}
