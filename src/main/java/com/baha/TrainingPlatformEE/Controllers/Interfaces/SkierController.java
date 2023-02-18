package com.baha.TrainingPlatformEE.Controllers.Interfaces;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import static com.baha.TrainingPlatformEE.Utils.Constant.APP_ROOT ;

public interface SkierController {

    @PostMapping(value =  APP_ROOT + "/Skiers/Skier", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    SkierDTO Save (@RequestBody SkierDTO skierdto) ;
    @GetMapping(value = APP_ROOT + "Skiers/{IdSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    SkierDTO findById (@PathVariable("IdSkier") Integer id) ;
    @GetMapping(value = APP_ROOT + "Skiers/{NumSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    SkierDTO findByNum (@PathVariable("NumSkier") Long Num) ;
    @GetMapping(value = APP_ROOT + "/Skiers" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<SkierDTO> findAll() ;

    @GetMapping(value = APP_ROOT + "/Skiers/{IdSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    void Delete (Integer id)  ;
}
