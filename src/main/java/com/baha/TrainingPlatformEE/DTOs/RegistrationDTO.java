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
    private Integer ID  ;

    private Long  numRegistration ;
    private int numWeek ;

    private CourseDTO course ;


    private SkierDTO skier ;

    public RegistrationDTO FromEntity(Registration registration)
    {
        if (registration == null ) {return null ; }

        return RegistrationDTO.builder()
                .ID(registration.getID())
                //.course(registration.getCourse())
                .numWeek(registration.getNumWeek())
                .numRegistration(registration.getNumRegistration())
                //skier
                .build() ;
    }
    public Registration ToEntity(RegistrationDTO registrationdto)
    {
        if ( registrationdto == null ) {return null ; }
        Registration registration = new Registration() ;
        registration.setID(registrationdto.getID());
        registration.setNumWeek(registrationdto.getNumWeek());
        registration.setNumRegistration(registrationdto.getNumRegistration());
        //skier
        //course

        return registration ;
    }
}
