package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Course;
import com.baha.TrainingPlatformEE.Models.Instructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Builder
@Data

public class InstructorDTO {
    private Integer ID  ;

    private Long NumInstructor ;
    private  String firstName ;
    private String lastName ;
    private Date DateOfHire ;


    private List<CourseDTO> Courses ;

    public InstructorDTO FromEntity(Instructor instructor)
    {
        if (instructor==null) { return null ; }
        return InstructorDTO.builder()
                .ID(instructor.getID())
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .DateOfHire(instructor.getDateOfHire())
                .NumInstructor(instructor.getNumInstructor())
                //.COURSES !!

                .build() ;
    }
    public Instructor ToEntity(InstructorDTO instructordto)
    {
        if (instructordto == null ) { return null ; }
        Instructor instructor = new Instructor() ;
        instructor.setID(instructordto.getID());
        instructor.setFirstName(instructordto.getFirstName());
        instructor.setLastName(instructordto.getLastName());
        instructor.setDateOfHire(instructordto.getDateOfHire());
        instructor.setNumInstructor(instructordto.getNumInstructor());
        //courses

        return instructor ;
    }
}
