package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class CourseDTO {

    private Long NumCourse ;
    private int  Level ;
    private TypeCourse typecourse ;
    private Support support ;
    private float Price ;
    private int TimeSlot ;


    private List<RegistrationDTO> registrations ;

    public static CourseDTO FromEntity(Course course)
    {
        if (course ==null) { return null ; }
        return CourseDTO.builder()
                .Level(course.getLevel())
                .Price(course.getPrice())
                .TimeSlot(course.getTimeSlot())
                .NumCourse(course.getNumCourse())
                .support(course.getSupport())
                .typecourse(course.getTypecourse())
                .registrations(
                        course.getRegistrations()
                                .stream()
                                .map(RegistrationDTO::FromEntity)
                                .collect(Collectors.toList())
                )

                .build();
    }
    public static Course ToEntity(CourseDTO coursedto)
    {
        if ( coursedto == null ) { return null ; }
        return Course.builder()
                .Level(coursedto.getLevel())
                .typecourse(coursedto.getTypecourse())
                .Price(coursedto.getPrice())
                .TimeSlot(coursedto.getTimeSlot())
                .NumCourse(coursedto.getNumCourse())
                .support(coursedto.getSupport())
                .registrations(
                        coursedto.getRegistrations() !=null ?
                                coursedto.getRegistrations()
                                        .stream()
                                        .map(RegistrationDTO::ToEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build() ;
     }

}
