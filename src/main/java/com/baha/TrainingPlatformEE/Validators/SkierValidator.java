package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.CompanyDTO;
import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SkierValidator {
    public static List<String> Validate (SkierDTO skierdto)
    {
        List<String> Errors = new ArrayList<>() ;
        if(skierdto==null)
        {
            Errors.add("full name required") ;
            Errors.add("Skier Photo required") ;
            Errors.add("Address required") ;



        }

         if(StringUtils.hasLength(skierdto.getFirstName()) || StringUtils.hasLength(skierdto.getLastName()) )
         {
             Errors.add("full name required") ;
         }
        if(StringUtils.hasLength(skierdto.getPhoto()))
        {
            Errors.add("Skier Photo required") ;
        }
        if(skierdto.getAddress() ==null )
        {
            Errors.add("Address required") ;
        }
        return Errors ;
    }

}
