package com.baha.TrainingPlatformEE.Controllers;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.baha.TrainingPlatformEE.Utils.Constant.APP_ROOT ;
@RestController
public class UserController {
    @PostMapping(path = APP_ROOT+"/Users/User",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO save(UserDTO userdto) { return null ; };

    @GetMapping(path = APP_ROOT+"Users/{UserId}",produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO findById(@PathVariable(name = "UserId") Integer id) {return null ; };

}
