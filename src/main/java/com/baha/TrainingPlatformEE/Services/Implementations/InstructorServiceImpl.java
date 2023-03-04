package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.InstructorDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Instructor;
import com.baha.TrainingPlatformEE.Repositories.InstructorRepository;
import com.baha.TrainingPlatformEE.Services.InstructorService;
import com.baha.TrainingPlatformEE.Validators.InstructorValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository _instructor ;
    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository)
    {
        _instructor = instructorRepository ;
    }
    @Override
    public InstructorDTO Save(InstructorDTO instructorDTO) {
        List<String> errors = InstructorValidator.Validate(instructorDTO) ;
        if(!errors.isEmpty()) {
            log.error("NOT VALID");
            throw new InvalidEntityException("Instructor entity is INVALID", ErrorCode.INSTRUCTOR_NOT_VALID,errors) ;


        }
        return InstructorDTO.FromEntity(_instructor.save(InstructorDTO.ToEntity(instructorDTO))) ;
    }


    @Override
    public InstructorDTO findByInstructorNum(Long instructorNum) {

        if(instructorNum==null)
        {
            log.error("Null PARAMETER");
            return null ;
        }
        Optional<Instructor> instructor = _instructor.findById(instructorNum) ;
        return Optional.of(InstructorDTO.FromEntity(instructor.get())).orElseThrow(()->
                new EntityNotFoundException("INSTRUCTOR WAS NOT FOUND",ErrorCode.INSTRUCTOR_NOT_FOUND)) ;
    }

    @Override
    public List<InstructorDTO> findAll() {
        return _instructor.findAll().stream().map(InstructorDTO::FromEntity).collect(Collectors.toList());
    }

    @Override
    public void Delete(Long InstructorNum) {
        if (InstructorNum==null)
        {
            log.error("NULL INSTRUCTOR ID");
        }
        _instructor.deleteById(InstructorNum);

    }
}
