package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.CourseDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CourseValidator {
    public static List<String> Validate (CourseDTO courseDTO)
    {
        List<String> Errors = new ArrayList<>() ;

        if(courseDTO.getPrice()==0)
        {
            Errors.add("Price is Required") ;
        }
        if(courseDTO==null)
        {
            Errors.add("NOT VALIUD INPUT") ;
        }


        return Errors ;

    }
}
