package com.baha.TrainingPlatformEE.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

// you can see the difference between entity which is issued from the Hibernate jpa dependancy and data which means class !!
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Courses")
public class Course extends AbstractEntity {
    private Long NumCourse ;
    private int  Level ;
    private TypeCourse typecourse ;
    private  Support support ;
    private float Price ;
    private int TimeSlot ;
}
