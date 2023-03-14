package com.baha.TrainingPlatformEE.Controllers;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Services.SkierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.baha.TrainingPlatformEE.Utils.Constant.APP_ROOT ;

@RestController
@Api(APP_ROOT+"/Skiers")
public class SkierController {

    @Autowired
    private SkierService _SkierService ;
    public SkierController(SkierService skierService )
    {
        _SkierService = skierService ;
    }

    @PostMapping(value =  APP_ROOT + "/Skiers/newSkier", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Skier",notes = "creating a new skier and add it to the database" , response = SkierDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200 , message = "Skier is successfully created"),
            @ApiResponse(code=400,message = "Bad Request")

    })
    SkierDTO Save (@RequestBody SkierDTO skierdto) { return _SkierService.Save(skierdto) ; };

    @GetMapping(value = APP_ROOT + "Skiers/{NumSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "searching for a specific Skier",notes = "Querying the desired skier from the database" , response = SkierDTO.class)
    @ApiResponses({
            @ApiResponse(code = 200 , message = " the desired skier is founded") ,
            @ApiResponse(code=404,message = "the skier is not found")
    })
    SkierDTO findById (@PathVariable("NumSkier") Long id) {return _SkierService.findBySkierNum(id) ; };
   // @GetMapping(value = APP_ROOT + "Skiers/{NumSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    //SkierDTO findByNum (@PathVariable("NumSkier") Long Num) {return null ; };
    @GetMapping(value = APP_ROOT + "/Skiers" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "querying all Skiers data from the database" , notes = "get all method" , responseContainer = "List<SkierDTO>")
    @ApiResponse(code = 200 , message = "nothing to say :p ")
    List<SkierDTO> findAll() {return _SkierService.findAll(); };

    @DeleteMapping(value = APP_ROOT + "/Skiers/delete/{IdSkier}", produces = MediaType.APPLICATION_JSON_VALUE)
    void Delete (Long id) { _SkierService.Delete(id); } ;
}
