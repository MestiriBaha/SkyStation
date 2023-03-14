package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Address;
import com.baha.TrainingPlatformEE.Models.Company;
import com.baha.TrainingPlatformEE.Models.Role;
import com.baha.TrainingPlatformEE.Models.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UserDTO {
    private Integer ID  ;

    private String FirstName ;
    private String LastName ;
    private String Email ;
    private Instant Birthday ;

    public static int calculateAge(Instant birthDate) {
        if ((birthDate==null)) {
            return 0 ;
        }
            Instant comparaison = Instant.now() ;
            LocalDate localDate1 = LocalDateTime.ofInstant(comparaison, ZoneOffset.UTC).toLocalDate();
            LocalDate localDate2 = LocalDateTime.ofInstant(birthDate, ZoneOffset.UTC).toLocalDate();


        return Period.between(localDate2, localDate1).getYears();
        }
        private int Age ;
        private String Password ;

    private AddressDTO Address ;
    private String photo ;

    private List<RoleDTO> roles ;
    private CompanyDTO company ;

    //Mapping methods : we will be using the donkey method ! at least we will be learning two methods for now !

    public static UserDTO FromEntity(User user)
    {
        if (user==null)  { return null ; //throw an exception
             }
        return UserDTO.builder()
                .Email(user.getEmail())
                //.Password(user.getPassword()) : confidential data !
                .FirstName(user.getFirstName())
                .LastName(user.getLastName())
                .Age(UserDTO.calculateAge(user.getBirthday()))
                .photo(user.getPhoto())
                .ID(user.getID())
                .Address(AddressDTO.FromEntity(user.getAddress()))
                .company(CompanyDTO.FromEntity(user.getCompany()))
                .roles(
                        user.getRoles()  != null ?
                                user.getRoles()
                        .stream()
                        .map(RoleDTO::FromEntity)
                        .collect(Collectors.toList()) : null )
                        .build();
    }

    //the method looks so naive :/
    public static User ToEntity(UserDTO userdto)
    {
        if (userdto == null ) {
            return null ;
        }
        return User.builder()
                .ID(userdto.getID())
                .Address(AddressDTO.ToEntity(userdto.getAddress()))
                .firstName(userdto.getFirstName())
                .LastName(userdto.getLastName())
                .Password(userdto.getPassword())
                .Email(userdto.getEmail())
                .Birthday(userdto.getBirthday())
                .photo(userdto.getPhoto())
                .company(CompanyDTO.ToEntity(userdto.getCompany()))

                .build() ;
    }

}
