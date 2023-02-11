package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Instructor;
import com.baha.TrainingPlatformEE.Models.Registration;
import com.baha.TrainingPlatformEE.Models.Support;
import com.baha.TrainingPlatformEE.Models.TypeCourse;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class CourseDTO {
    private Long NumCourse ;
    private int  Level ;
    private TypeCourse typecourse ;
    private Support support ;
    private float Price ;
    private int TimeSlot ;

    private InstructorDTO instructor ;

    private List<RegistrationDTO> registrations ;

}
