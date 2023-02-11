package com.baha.TrainingPlatformEE.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private String Address1 ;
    private String Address2 ;
    private String City ;

}
