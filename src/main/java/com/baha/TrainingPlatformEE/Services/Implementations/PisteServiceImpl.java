package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.PisteDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Piste;
import com.baha.TrainingPlatformEE.Repositories.PisteRepository;
import com.baha.TrainingPlatformEE.Services.PisteService;
import com.baha.TrainingPlatformEE.Validators.PisteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PisteServiceImpl implements PisteService {
    PisteRepository _pisterepository ;
    @Autowired
    public PisteServiceImpl(PisteRepository pisteRepository)
    {
        _pisterepository =  pisteRepository ;
    }
    @Override
    public PisteDTO Save(PisteDTO pisteDTO) {
        List<String> errors = PisteValidator.validate(pisteDTO) ;
        if(!errors.isEmpty()) {
            log.error("NOT VALID");
            throw new InvalidEntityException("Piste entity is INVALID", ErrorCode.PISTE_NOT_VALID,errors) ;


        }
        return PisteDTO.FromEntity(_pisterepository.save(PisteDTO.ToEntiy(pisteDTO))) ;
    }

    @Override
    public PisteDTO findByPisteNum(Long PisteNum) {
        if(PisteNum==null)
        {
            log.error("Null PARAMETER");
            return null ;
        }
        Optional<Piste> piste = _pisterepository.findById(PisteNum) ;
        return Optional.of(PisteDTO.FromEntity(piste.get())).orElseThrow(()->
                new EntityNotFoundException("Piste WAS NOT FOUND",ErrorCode.PISTE_NOT_FOUND)) ;
    }

    @Override
    public List<PisteDTO> findAll() {
        return _pisterepository.findAll().stream().map(PisteDTO::FromEntity).collect(Collectors.toList());
    }

    @Override
    public void Delete(Long PisteNum) {
        if (PisteNum==null)
        {
            log.error("NULL ID ");
        }
        _pisterepository.deleteById(PisteNum);
    }
}
