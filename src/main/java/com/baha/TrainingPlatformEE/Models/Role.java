package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Roles")
@Builder
public class Role extends AbstractEntity{
    @Id
    private Integer Roleid ;

    private String RoleName ;
    //@ManyToOne
    //@JoinColumn(name = "IdUser")
    //private User user ;
}
