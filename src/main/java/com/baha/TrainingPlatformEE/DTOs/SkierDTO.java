package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class SkierDTO {
    private Integer ID  ;

    private Long NumSkier ;
    private String FirstName ;
    private String LastName ;
    private Date DateOfBirth ;

    private AddressDTO address ;
    private String Photo ;

    private SubscriptionDTO subscription ;

    private List<RegistrationDTO> registration ;

    private List<PisteDTO> Pistes ;

    public static SkierDTO FromEntity(Skier skier)
    {
        if ( skier == null ) { return null ; }
        return  SkierDTO.builder()
                .FirstName(skier.getFirstName())
                .LastName(skier.getLastName())
                .Photo(skier.getPhoto())
                .DateOfBirth(skier.getDateOfBirth())
                .NumSkier(skier.getNumSkier())
                .ID(skier.getID())
                //list of piste dto
                //registration dto list
                //address dto
                //subscription
                .build() ;
    }
    public static Skier ToEntity(SkierDTO skierdto)
    {
        if ( skierdto == null ) { return null ; }
        Skier skier = new Skier() ;
        skier.setNumSkier(skierdto.getNumSkier());
        skier.setPhoto(skierdto.getPhoto());
        skier.setID(skier.getID());
        skier.setDateOfBirth(skier.getDateOfBirth());
        skier.setFirstName(skierdto.getFirstName());
        skier.setLastName(skier.getLastName());
        //piste dto
        // regsitration
        // address
        //subsciption
        return skier ;



    }
}
