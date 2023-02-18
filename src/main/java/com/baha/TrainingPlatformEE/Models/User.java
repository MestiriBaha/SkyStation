package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "AppUsers")
public class User extends  AbstractEntity {
    private String FirstName ;
    private String LastName ;
    private String Email ;
    private Instant Birthday ;
    private String Password ;
    @Embedded
    private Address Address ;
    private String photo ;
    @OneToMany()
    private List<Role> roles ;

    //@JoinColumn(name = "CompanyID")
    @ManyToOne()
    private Company company ;


}
