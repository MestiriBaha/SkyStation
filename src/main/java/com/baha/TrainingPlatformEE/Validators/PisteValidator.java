package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.PisteDTO;

import java.util.ArrayList;
import java.util.List;

public class PisteValidator {
    public static List<String> validate (PisteDTO pisteDTO)
    {
        List<String> errors = new ArrayList<>() ;
        if(pisteDTO==null)
        {
            errors.add("ERROR") ;
        }
        return errors ;
    }
}
