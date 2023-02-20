package com.baha.TrainingPlatformEE.Controllers;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Services.Implementations.SkierService;
import com.baha.TrainingPlatformEE.Services.SkierInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkierController implements SkierInterface {

    //We have 3 types on injections
    //First one , Constructor injection
    private SkierInterface _SkierService ;
    @Autowired
    public SkierController(SkierService skierService)
    {
        _SkierService = skierService ;
    }

    //Second one , FIELD Injection
    //3rd one Setter Injection
    @Override
    public SkierDTO Save(SkierDTO skierdto) {
        return _SkierService.Save(skierdto);
    }

    @Override
    public SkierDTO findById(Integer id) {
        return _SkierService.findById(id);
    }

    @Override
    public SkierDTO findByNum(Long Num) {
        return _SkierService.findByNum(Num);
    }

    @Override
    public List<SkierDTO> findAll() {
        return _SkierService.findAll();
    }

    @Override
    public void Delete(Integer id) {
        _SkierService.Delete(id);

    }
}
