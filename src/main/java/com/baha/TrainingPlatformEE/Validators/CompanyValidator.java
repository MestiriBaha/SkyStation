package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.CompanyDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator {

    public static List<String> Validate (CompanyDTO companydto)
    {
        List<String> Errors = new ArrayList<>() ;

        if(!StringUtils.hasLength(companydto.getName()))
        {
            Errors.add("Company Name Required") ;
        }
        if(!StringUtils.hasLength(companydto.getDescription()))
        {
            Errors.add("Company Description Required") ;
        }
        if(companydto.getAddress()==null)
        {
            Errors.add("Company Address Required") ;
        }
        if(!StringUtils.hasLength(companydto.getAddress().getAddress1()))
        {
            Errors.add("Exact Address Required") ;
        }


        return Errors ;

    }
}
