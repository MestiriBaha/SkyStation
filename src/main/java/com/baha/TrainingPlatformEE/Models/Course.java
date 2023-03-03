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
@Getter
@Setter

@Table(name = "Courses")
public class Course extends AbstractEntity {
    @Id
    private Long NumCourse ;
    private int  Level ;
    @Enumerated(EnumType.STRING)
    private TypeCourse typecourse ;
    @Enumerated(EnumType.STRING)
    private  Support support ;
    private float Price ;
    private int TimeSlot ;
    //@ManyToOne
    //@JoinColumn(name = "NumInstructor")
    //private Instructor instructor ;
    @OneToMany(mappedBy = "course")
    private List<Registration> registrations ;

}
