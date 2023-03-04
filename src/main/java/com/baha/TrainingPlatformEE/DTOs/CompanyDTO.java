package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Address;
import com.baha.TrainingPlatformEE.Models.Company;
import com.baha.TrainingPlatformEE.Models.User;
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
    private List<UserDTO> Users ;
    public static CompanyDTO FromEntity(Company company)
    {
        if (company == null) {return null ; }
        return CompanyDTO.builder()
                .ID(company.getID())
                .Name(company.getName())
                .Photo(company.getPhoto())
                .Email(company.getEmail())
                .WebSite(company.getSiteWeb())
                .Description(company.getDescription())
                //.Address()

                .build();
    }
    public static Company ToEntity(CompanyDTO companydto){
        if (companydto == null) {return null ; }
        Company company = new Company() ;
        company.setDescription(companydto.getDescription());
        company.setEmail(companydto.getEmail());
        company.setPhoto(companydto.getPhoto());
        company.setName(companydto.getName());
        company.setSiteWeb(companydto.getWebSite());
        company.setID(companydto.getID());
        //company.Address(companydto.getDescription());
        // we have to take care of the associations !
        return company ;


    }
}
