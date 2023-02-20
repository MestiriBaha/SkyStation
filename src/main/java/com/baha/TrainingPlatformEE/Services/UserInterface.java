package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;

import java.util.List;

public interface UserInterface {
    UserDTO Save (UserDTO userdto) ;
    UserDTO findById (Integer id) ;
    UserDTO findByName (String Name) ;

    List<UserDTO> findAll() ;

    void Delete (Integer id)  ;
}
