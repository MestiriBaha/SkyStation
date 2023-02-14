package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class CourseDTO {
    private Integer ID  ;

    private Long NumCourse ;
    private int  Level ;
    private TypeCourse typecourse ;
    private Support support ;
    private float Price ;
    private int TimeSlot ;

    private InstructorDTO instructor ;

    private List<RegistrationDTO> registrations ;

    public CourseDTO FromEntity(Course course)
    {
        if (course ==null) { return null ; }
        return CourseDTO.builder()
                .ID(course.getID())
                .Level(course.getLevel())
                .Price(course.getPrice())
                .TimeSlot(course.getTimeSlot())
                .NumCourse(course.getNumCourse())
                .support(course.getSupport())
                .typecourse(course.getTypecourse())
                //.instructor(course.getInstructor())
                //registrations !

                .build();
    }
    public Course ToEntity(CourseDTO coursedto)
    {
        if ( coursedto == null ) { return null ; }
        Course course = new Course() ;
        course.setID(coursedto.getID());
        course.setNumCourse(coursedto.getNumCourse());
        course.setPrice(coursedto.getPrice());
        course.setSupport(coursedto.getSupport());
        course.setTypecourse(coursedto.getTypecourse());
        course.setTimeSlot(coursedto.getTimeSlot());
        //course.setInstructor(coursedto.getInstructor());
        //registrations

        return course ;

    }

}
