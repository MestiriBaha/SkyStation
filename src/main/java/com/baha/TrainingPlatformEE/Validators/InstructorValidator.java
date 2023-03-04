package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.InstructorDTO;

import java.util.ArrayList;
import java.util.List;

public class InstructorValidator {

    public static List<String> Validate(InstructorDTO instructorDTO)

    {
        List<String> errors = new ArrayList<>() ;
        if(!errors.isEmpty())
        {
            errors.add("ERROR") ;
        }
        return errors ;
    }
}
