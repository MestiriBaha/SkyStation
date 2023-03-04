package com.baha.TrainingPlatformEE.Validators;

import com.baha.TrainingPlatformEE.DTOs.SubscriptionDTO;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionValidator {
    public static List<String> validate (SubscriptionDTO subscriptionDTO) {
        List<String> errors = new ArrayList<>() ;
        if (subscriptionDTO==null)
        {
            errors.add("ERROR !! ") ;
        }
        //there is so much to implement here !!
        //as specifying the null properties !!
        return errors ;
    }
}
