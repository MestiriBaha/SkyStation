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
    public static RoleDTO FromEntity(Role role)
    {
        if (role == null ) { return null ; }
        return RoleDTO.builder()
                .ID(role.getRoleid())
                .RoleName(role.getRoleName())
                .build() ;
    }
    public static Role ToEntity(RoleDTO roledto)
    {
        if (roledto == null ) { return null ; }
        return
                 Role.builder()
                .Roleid(roledto.getID())
                .RoleName(roledto.getRoleName())
                .build() ;
    }
}
