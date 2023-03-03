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
    //the same for FirstName i have to change it to firstName !!
    @Column(name = "UserID")
    @Id
    private Integer ID  ;
    private String firstName ;
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
