package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Address;
import com.baha.TrainingPlatformEE.Models.Company;
import com.baha.TrainingPlatformEE.Models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class CompanyDTO {
    private Integer ID  ;

    private String Name ;
    private String Description ;

    private AddressDTO Address ;
    private String Photo ;
    private String Email ;
    private String WebSite ;
    @JsonIgnore
    private List<UserDTO> Users ;
    public static CompanyDTO FromEntity(Company company)
    {
        if (company == null) {return null ; }
        return CompanyDTO.builder()
                .Name(company.getName())
                .Photo(company.getPhoto())
                .Email(company.getEmail())
                .WebSite(company.getSiteWeb())
                .Description(company.getDescription())
                .Address(AddressDTO.FromEntity(company.getAddress()))
                //we are not going to show the users  !! it is a choice more than an implementation !!
                .build();
    }
    public static Company ToEntity(CompanyDTO companydto){
        if (companydto == null) {return null ; }
        return Company.builder()
                .Companyid(companydto.getID())
                .Description(companydto.getDescription())
                .Email(companydto.getEmail())
                .Photo(companydto.getPhoto())
                .Name(companydto.getName())
                .Address(AddressDTO.ToEntity(companydto.getAddress()))
                .build() ;


    }
}
