package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Course;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Builder
@Data

public class InstructorDTO {
    private Long NumInstructor ;
    private  String firstName ;
    private String lastName ;
    private Date DateOfHire ;


    private List<CourseDTO> Courses ;
}
