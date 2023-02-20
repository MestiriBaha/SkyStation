package com.baha.TrainingPlatformEE.Controllers.Interfaces;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.baha.TrainingPlatformEE.Utils.Constant.APP_ROOT ;

public interface UserController {
    @PostMapping(path = APP_ROOT+"/Users/User",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO save(UserDTO userdto) ;

    @GetMapping(path = APP_ROOT+"Users/{UserId}",produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO findById(@PathVariable(name = "UserId") Integer id) ;

}
