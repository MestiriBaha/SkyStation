package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Address;
import com.baha.TrainingPlatformEE.Repositories.AddressRepository;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
    private String Address1 ;
    private String Address2 ;
    private String City ;

    public static AddressDTO FromEntity(Address address) {
        if(address==null) { return null ; }
        return AddressDTO.builder()
                .Address1(address.getAddress1())
                .Address2(address.getAddress2())
                .City(address.getCity())
                .build() ;
    }
    public static Address ToEntity(AddressDTO addressDTO)
    {
        if (addressDTO ==null) { return  null ; }
        return Address.builder()
                .Address1(addressDTO.getAddress1())
                .Address2(addressDTO.getAddress2())
                .City(addressDTO.getCity())
                .build();
    }


}
