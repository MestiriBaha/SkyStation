package com.baha.TrainingPlatformEE.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

// you can see the difference between entity which is issued from the Hibernate jpa dependancy and data which means class !!
@Data
@Entity
@NoArgsConstructor
//@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Table(name = "Courses")
public class Course extends AbstractEntity {
    private Long NumCourse ;
    private int  Level ;
    private TypeCourse typecourse ;
    private  Support support ;
    private float Price ;
    private int TimeSlot ;
    @ManyToOne
    @JoinColumn(name = "NumInstructor")
    private Instructor instructor ;
    @OneToMany(mappedBy = "course")
    private List<Registration> registrations ;

}
