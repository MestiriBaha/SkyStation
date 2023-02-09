package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SkiersTable")
public class Skier extends AbstractEntity {
    private Long NumSkier ;
    private String FirstName ;
    private String LastName ;
    private Date DateOfBirth ;
    private String City ;
}
