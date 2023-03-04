package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Skier;
import com.baha.TrainingPlatformEE.Repositories.SkierRepository;
import com.baha.TrainingPlatformEE.Services.SkierService;
import com.baha.TrainingPlatformEE.Validators.SkierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class SkierServiceImpl implements SkierService {

    private SkierRepository _skierRepository ;
    @Autowired
    public SkierServiceImpl(SkierRepository skierRepository)
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
    public SkierDTO findBySkierNum(Long skierNum) {
        if(skierNum == null)
        {
            log.error("The Skier Num is not valid");
            return null ;
        }
        Optional<Skier> skier = _skierRepository.findById(skierNum) ;
        return Optional.of(SkierDTO.FromEntity(skier.get())).orElseThrow(
                () -> new EntityNotFoundException("Searched entity is not found",ErrorCode.SKIER_NOT_FOUND)) ;

    }
    @Override
    public List<SkierDTO> findAll() {
        return _skierRepository.findAll().stream()
                .map(SkierDTO::FromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void Delete(Long skierNum) {
        if(skierNum==null)
        {
            log.error(" SkierNum is invalid ");

            return  ;
        }
         _skierRepository.deleteById(skierNum);


    }
}
