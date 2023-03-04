package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO Save (UserDTO userdto) ;
    UserDTO findById (Integer id) ;

    List<UserDTO> findAll() ;

    void Delete (Integer id)  ;
}
