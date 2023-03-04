package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.RegistrationDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Registration;
import com.baha.TrainingPlatformEE.Repositories.RegistrationRepository;
import com.baha.TrainingPlatformEE.Services.RegistrationService;
import com.baha.TrainingPlatformEE.Validators.RegistrationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationRepository _registrationRepository ;
    @Autowired
    public RegistrationServiceImpl (RegistrationRepository registrationRepository)
    {
        _registrationRepository = registrationRepository;
    }
    @Override
    public RegistrationDTO Save(RegistrationDTO registrationDTO) {
            List<String> errors = RegistrationValidator.validate(registrationDTO) ;
            if(!errors.isEmpty()) {
                log.error("NOT VALID");
                throw new InvalidEntityException("Registration entity is INVALID", ErrorCode.REGISTRATION_NOT_VALID,errors) ;


            }
            return RegistrationDTO.FromEntity(_registrationRepository.save(RegistrationDTO.ToEntity(registrationDTO))) ;
    }

    @Override
    public RegistrationDTO findByRegistrationNum(Long registrationNum) {
        if(registrationNum==null)
        {
            log.error("Null PARAMETER");
            return null ;
        }
        Optional<Registration> registration = _registrationRepository.findById(registrationNum) ;
        return Optional.of(RegistrationDTO.FromEntity(registration.get())).orElseThrow(()->
                new EntityNotFoundException("REGISTRATION WAS NOT FOUND",ErrorCode.REGISTRATION_NOT_FOUND)) ;
    }

    @Override
    public List<RegistrationDTO> findAll() {
        return _registrationRepository.findAll().stream().map(RegistrationDTO::FromEntity).collect(Collectors.toList());
    }

    @Override
    public void Delete(Long registrationNum) {
        if(registrationNum==null)
        {
            log.error("NULL ID");
            return ;
        }
        _registrationRepository.deleteById(registrationNum);



    }
}
