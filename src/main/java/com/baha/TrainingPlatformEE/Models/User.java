package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
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
    @OneToMany(mappedBy = "user")
    private List<Role> roles ;


}
