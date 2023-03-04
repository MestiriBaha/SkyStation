package com.baha.TrainingPlatformEE.Controllers;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;
import com.baha.TrainingPlatformEE.Services.Implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements com.baha.TrainingPlatformEE.Controllers.Interfaces.UserController {

    private UserServiceImpl _userservice ;
    @Autowired
    public UserController(UserServiceImpl userservice)
    {
        _userservice = userservice ;
    }
    @Override
    public UserDTO save(UserDTO userdto) {
        return _userservice.Save(userdto);
    }

    @Override
    public UserDTO findById(Integer id) {
        return _userservice.findById(id);
    }
}
