package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.UserDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.User;
import com.baha.TrainingPlatformEE.Repositories.UserRepository;
import com.baha.TrainingPlatformEE.Services.UserService;
import com.baha.TrainingPlatformEE.Validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository _UserRepository ;
    @Autowired

    public UserServiceImpl(UserRepository userRepository)
    {
        _UserRepository = userRepository ;
    }
    @Override
    public UserDTO Save(UserDTO userdto) {
        List<String> errors = UserValidator.Validate(userdto) ;
        if (!errors.isEmpty()) {

            log.error("Invalid User",userdto);
            throw new InvalidEntityException("user is not valid", ErrorCode.USER_NOT_VALID,errors) ;

        }
        return UserDTO.FromEntity(_UserRepository.save(UserDTO.ToEntity(userdto))) ;
        //Gut Gemacht
    }

    @Override
    public UserDTO findById(Integer id) {
        if(id==null)
        {
            //always remember to log your errors !
            log.error("Id is null");
            return null ;
            //be careful , there is a difference between OrElse and OrElseThrow !
        }
        Optional<User> user = _UserRepository.findById(id) ;
        return Optional.of(UserDTO.FromEntity(user.get())).orElseThrow(()->
                new EntityNotFoundException("entity not found",ErrorCode.USER_NOT_FOUND)) ;

    }


    @Override
    public List<UserDTO> findAll() {

        return _UserRepository.findAll().stream()
                .map(UserDTO::FromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void Delete(Integer id) {
        if(id==null)
        {
            log.error("User ID is Null !! ");
            return ;
        }
         _UserRepository.deleteById(id);
    }
}
