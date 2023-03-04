package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.CompanyDTO;
import com.baha.TrainingPlatformEE.DTOs.CourseDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Company;
import com.baha.TrainingPlatformEE.Models.Course;
import com.baha.TrainingPlatformEE.Repositories.CourseRepository;
import com.baha.TrainingPlatformEE.Services.CourseService;
import com.baha.TrainingPlatformEE.Validators.CompanyValidator;
import com.baha.TrainingPlatformEE.Validators.CourseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    private CourseRepository _courseRepository ;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository)
    {
        _courseRepository = courseRepository ;
    }
    @Override
    public CourseDTO Save(CourseDTO courseDTO) {
        List<String> errors = CourseValidator.Validate(courseDTO) ;
        if(!errors.isEmpty())
        {
            log.error("INVALID INPUT");
            throw new InvalidEntityException("INVALID ENTITY ", ErrorCode.COURSE_NOT_VALID,errors) ;
        }
        return CourseDTO.FromEntity(_courseRepository.save(CourseDTO.ToEntity(courseDTO))) ;
    }

    @Override
    public CourseDTO findByPisteNum(Long courseNum) {
        if(courseNum==null)
        {
            log.error("ID IS NULL ");
            return null ;
        }
        Optional<Course> course = _courseRepository.findById(courseNum) ;
        return Optional.of(CourseDTO.FromEntity(course.get())).orElseThrow(()->
                new EntityNotFoundException("SEARCHED COURSE WAS NOT FOUND",ErrorCode.COURSE_NOT_FOUND)) ;

    }

    @Override
    public List<CourseDTO> findAll() {
        return _courseRepository.findAll().stream().map(CourseDTO::FromEntity).collect(Collectors.toList());
    }

    @Override
    public void Delete(Long courseNum) {

        if(courseNum==null)
        {
            log.error("ERROR");
        }
        _courseRepository.deleteById(courseNum);

    }
}
