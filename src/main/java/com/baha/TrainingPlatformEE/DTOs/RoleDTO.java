package com.baha.TrainingPlatformEE.DTOs;

import com.baha.TrainingPlatformEE.Models.Role;
import com.baha.TrainingPlatformEE.Models.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@Data
public class RoleDTO {
    private Integer ID  ;

    private String RoleName ;


    private UserDTO use ;
    public RoleDTO FromEntity(Role role)
    {
        if (role == null ) { return null ; }
        return RoleDTO.builder()
                .ID(role.getID())
                .RoleName(role.getRoleName())
                //userdto
                .build() ;
    }
    public Role ToEntity(RoleDTO roledto)
    {
        if (roledto == null ) { return null ; }
        Role role = new Role() ;
        role.setID(roledto.getID());
        role.setRoleName(roledto.getRoleName());
        //userdto
        return role ;
    }
}
