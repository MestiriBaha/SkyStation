package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> Validate(UserDTO userdto)
    {
        List<String> Errors = new ArrayList<>() ;
        if (!StringUtils.hasLength(userdto.getFirstName()) || !StringUtils.hasLength(userdto.getLastName()))
        {
            Errors.add("Name is Required") ;
        }
        return Errors ;
    }
}
