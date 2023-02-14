package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Roles")
public class Role extends AbstractEntity{
    private String RoleName ;
    @ManyToOne
    @JoinColumn(name = "IdUser")
    private User user ;
}
