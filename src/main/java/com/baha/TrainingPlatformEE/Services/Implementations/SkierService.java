package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Skier;
import com.baha.TrainingPlatformEE.Repositories.SkierRepository;
import com.baha.TrainingPlatformEE.Services.SkierInterface;
import com.baha.TrainingPlatformEE.Validators.SkierValidator;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class SkierService implements SkierInterface {

    private SkierRepository _skierRepository ;
    @Autowired
    public SkierService(SkierRepository skierRepository)
    {
       _skierRepository = skierRepository ;
    }
    @Override
    public SkierDTO Save(SkierDTO skierdto) {
        List<String> errors = SkierValidator.Validate(skierdto) ;
        if (!errors.isEmpty())
        {
            log.error("Skier is not valid " , skierdto);
            throw new InvalidEntityException("Skier is not valid",ErrorCode.SKIER_NOT_VALID,errors) ;

        }

        return SkierDTO.FromEntity(_skierRepository.save(SkierDTO.ToEntity(skierdto))) ;
    }

    @Override
    public SkierDTO findById(Integer id) {
        if(id == null)
        {
            log.error("The Id is not valid");
            return null ;
        }
        Optional<Skier> skier = _skierRepository.findById(id) ;
        return Optional.of(SkierDTO.FromEntity(skier.get())).orElseThrow(
                () -> new EntityNotFoundException("Searched entity is not found",ErrorCode.SKIER_NOT_FOUND)) ;

    }

    //this method is personalised and Jpa Repository doesn't have a template of it !!
    @Override
    public SkierDTO findByNum(Long Num) {

        if(Num==0)
        {
            log.error("Numero Skier is null ");
            return null ;

        }
        Optional<Skier> skier = _skierRepository.findByNumSkier(Num) ;
        return Optional.of(SkierDTO.FromEntity(skier.get())).orElseThrow(() ->
                 new EntityNotFoundException("Searched Skier is not found",ErrorCode.SKIER_NOT_FOUND)) ;
    }

    @Override
    public List<SkierDTO> findAll() {
        return _skierRepository.findAll().stream()
                .map(SkierDTO::FromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void Delete(Integer id) {
        if(id==null)
        {
            log.error("id is invalid ");
            // i can't write implement null because we have void !! wake up !

            return  ;
        }
         _skierRepository.deleteById(id);

    }
}
