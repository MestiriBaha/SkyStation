package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.CompanyDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Company;
import com.baha.TrainingPlatformEE.Repositories.CompanyRepository;
import com.baha.TrainingPlatformEE.Services.CompanyService;
import com.baha.TrainingPlatformEE.Validators.CompanyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository _companyRepository ;
    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository)
    {
        _companyRepository = companyRepository ;
    }
    @Override
    public CompanyDTO Save(CompanyDTO companyDTO) {
        List<String> errors = CompanyValidator.Validate(companyDTO) ;
        if(!errors.isEmpty())
        {
            log.error("INVALID INPUT");
            throw new InvalidEntityException("INVALID ENTITY ", ErrorCode.COMPANY_NOT_VALID,errors) ;
        }
        return CompanyDTO.FromEntity(_companyRepository.save(CompanyDTO.ToEntity(companyDTO))) ;
    }

    @Override
    public CompanyDTO findBycompanyName(String companyName) {
        if(companyName==null)
        {
            log.error("ID IS NULL ");
            return null ;
        }
        Optional<Company> company = _companyRepository.findById(companyName) ;
        return Optional.of(CompanyDTO.FromEntity(company.get())).orElseThrow(()->
                new EntityNotFoundException("SEARCHED COMPANY WAS NOT FOUND",ErrorCode.COMPANY_NOT_FOUND)) ;

    }

    @Override
    public List<CompanyDTO> findAll() {
        return _companyRepository.findAll().stream().map(CompanyDTO::FromEntity).collect(Collectors.toList());
    }

    @Override
    public void Delete(String companyName) {
        if(companyName==null)
        {
            log.error("ERROR");
        }
        _companyRepository.deleteById(companyName);

    }
}
