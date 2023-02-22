package com.baha.TrainingPlatformEE.Controllers.Interfaces;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import static com.baha.TrainingPlatformEE.Utils.Constant.APP_ROOT ;

@Api(APP_ROOT+"/Skiers")
public interface SkierController {

    @PostMapping(value =  APP_ROOT + "/Skiers/Skier", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Skier",notes = "creating a new skier and add it to the database" , response = SkierDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200 , message = "Skier is successfully created"),
            @ApiResponse(code=400,message = "Bad Request")

    })
    SkierDTO Save (@RequestBody SkierDTO skierdto) ;

    @GetMapping(value = APP_ROOT + "Skiers/{IdSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "searching for a specific Skier",notes = "Querying the desired skier from the database" , response = SkierDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200 , message = " the desired skier is founded") ,
            @ApiResponse(code=404,message = "the skier is not found")
    })
    SkierDTO findById (@PathVariable("IdSkier") Integer id) ;
    @GetMapping(value = APP_ROOT + "Skiers/{NumSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    SkierDTO findByNum (@PathVariable("NumSkier") Long Num) ;
    @GetMapping(value = APP_ROOT + "/Skiers" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "querying all Skiers data from the database" , notes = "get all method" , responseContainer = "List<SkierDTO>")
    @ApiResponse(code = 200 , message = "nothing to say :p ")
    List<SkierDTO> findAll() ;

    @GetMapping(value = APP_ROOT + "/Skiers/{IdSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    void Delete (Integer id)  ;
}
