package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Instructors")
public class Instructor extends AbstractEntity{
    private Long NumInstructor ;
    private  String firstName ;
    private String lastName ;
    private Date DateOfHire ;


}
