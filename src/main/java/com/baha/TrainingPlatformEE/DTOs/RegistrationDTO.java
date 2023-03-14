package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Course;
import com.baha.TrainingPlatformEE.Models.Registration;
import com.baha.TrainingPlatformEE.Models.Skier;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class RegistrationDTO {

    private Long  numRegistration ;
    private int numWeek ;

    private CourseDTO course ;


    private SkierDTO skier ;

    public static RegistrationDTO FromEntity(Registration registration)
    {
        if (registration == null ) {return null ; }

        return RegistrationDTO.builder()
                .numWeek(registration.getNumWeek())
                .numRegistration(registration.getNumRegistration())
                .course(CourseDTO.FromEntity(registration.getCourse()))
                .skier(SkierDTO.FromEntity(registration.getSkier()))
                .build() ;
    }
    public static  Registration ToEntity(RegistrationDTO registrationdto)
    {
        if ( registrationdto == null ) {return null ; }
         return
                 Registration.builder()
                         .course(CourseDTO.ToEntity(registrationdto.getCourse()))
                         .numRegistration(registrationdto.getNumRegistration())
                         .numWeek(registrationdto.getNumWeek())
                         .skier(SkierDTO.ToEntity(registrationdto.getSkier()))

                         .build() ;
    }
}
