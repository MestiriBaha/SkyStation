package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.RegistrationDTO;

import java.util.ArrayList;
import java.util.List;

public class RegistrationValidator {

    public static List<String> validate (RegistrationDTO registrationDTO)
    {
        List<String> errors = new ArrayList<>() ;
        if(registrationDTO==null)
        {
            errors.add("ERROR") ;
        }
        return errors ;
    }
}
