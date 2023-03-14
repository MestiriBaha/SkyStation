package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class SkierDTO {

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
                .address(AddressDTO.FromEntity(skier.getAddress()))
                .Pistes(
                        skier.getPistes() != null ?
                        skier.getPistes()
                                .stream()
                                .map(PisteDTO::FromEntity)
                                .collect(Collectors.toList()) : null
                )
                .subscription(SubscriptionDTO.FromEntity(skier.getSubscription()))
                .registration(
                        //i NEED TO FULLY UNDERSTAND THESE NOTATIONS
                        skier.getRegistration() != null ?
                        skier.getRegistration()
                                .stream()
                                .map(RegistrationDTO::FromEntity)
                                .collect(Collectors.toList()) : null
                )
                .build() ;
    }
    public static Skier ToEntity(SkierDTO skierdto)
    {
        if ( skierdto == null ) { return null ; }
        return Skier.builder()
                .numSkier(skierdto.getNumSkier())
                .FirstName(skierdto.getFirstName())
                .LastName(skierdto.getLastName())
                .DateOfBirth(skierdto.getDateOfBirth())
                .address(AddressDTO.ToEntity(skierdto.getAddress()))
                .Photo(skierdto.getPhoto())
                .subscription(SubscriptionDTO.ToEntity(skierdto.getSubscription()))
                .registration(
                        skierdto.registration
                                .stream().map(
                                        RegistrationDTO::ToEntity
                                )
                                .collect(Collectors.toList())
                )
                .Pistes(
                        skierdto.Pistes
                                .stream().map(PisteDTO::ToEntiy)
                                .collect(Collectors.toList())
                )
                .build();



    }
}
