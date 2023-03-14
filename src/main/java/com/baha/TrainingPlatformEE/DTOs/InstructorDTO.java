package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Course;
import com.baha.TrainingPlatformEE.Models.Instructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data

public class InstructorDTO {

    private Long NumInstructor ;
    private  String firstName ;
    private String lastName ;
    private Date DateOfHire ;


    private List<CourseDTO> Courses ;

    public static InstructorDTO FromEntity(Instructor instructor)
    {
        if (instructor==null) { return null ; }
        return InstructorDTO.builder()
                .firstName(instructor.getFirstName())
                .lastName(instructor.getLastName())
                .DateOfHire(instructor.getDateOfHire())
                .NumInstructor(instructor.getNumInstructor())
                .Courses(
                        instructor.getCourses() != null  ?
                                instructor.getCourses()
                                        .stream().map(
                                                CourseDTO::FromEntity
                                        ).collect(Collectors.toList()) : null
                )

                .build() ;
    }
    public static Instructor ToEntity(InstructorDTO instructordto)
    {
        if (instructordto == null ) { return null ; }
         return Instructor.builder()
                 .NumInstructor(instructordto.getNumInstructor())
                 .firstName(instructordto.getFirstName())
                 .lastName(instructordto.getLastName())
                 .DateOfHire(instructordto.getDateOfHire())
                 .Courses(
                         instructordto.getCourses() !=null ?
                                 instructordto.getCourses()
                                         .stream()
                                         .map(CourseDTO::ToEntity)
                                         .collect(Collectors.toList()) : null
                 )
                 .build() ;
    }
}
