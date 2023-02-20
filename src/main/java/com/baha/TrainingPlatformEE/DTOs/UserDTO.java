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
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UserDTO {
    private Integer ID  ;

    private String FirstName ;
    private String LastName ;
    private String Email ;
    private Instant Birthday ;
    private String Password ;

    private AddressDTO Address ;
    private String photo ;

    private List<RoleDTO> roles ;
    private CompanyDTO company ;

    //Mapping methods : we will be using the donckey method ! at least we will be learning two methods for now !

    public static UserDTO FromEntity(User user)
    {
        if (user==null)  { return null ; //throw an exception
             }
        return UserDTO.builder()
                .Email(user.getEmail())
                .Password(user.getPassword())
                .FirstName(user.getFirstName())
                .LastName(user.getLastName())
                .Birthday(user.getBirthday())
                .photo(user.getPhoto())
                .ID(user.getID())
                //.Address(AddressDTO.fromEntity(user.getAddress()))
                //.company(CompanyDTO.fromEntity(user.getCompany()))

                .build();
    }

    //the method looks so naive :/
    public static User ToEntity(UserDTO userdto)
    {
        User user = new User() ;
        user.setEmail(userdto.getEmail());
        user.setPhoto(userdto.getPhoto());
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setPassword(userdto.getPassword());
        user.setID(userdto.getID());
        //user.setAddress(userdto.getAddress());
        //user.setCompany(userdto.getCompany());
        return user ;
    }

}
