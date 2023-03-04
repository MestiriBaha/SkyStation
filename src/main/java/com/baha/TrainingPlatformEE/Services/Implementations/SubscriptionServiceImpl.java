package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.SubscriptionDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Subscription;
import com.baha.TrainingPlatformEE.Repositories.SubscriptionRepository;
import com.baha.TrainingPlatformEE.Services.SubscriptionService;
import com.baha.TrainingPlatformEE.Validators.SubscriptionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
 @Slf4j

public class SubscriptionServiceImpl implements SubscriptionService {
     SubscriptionRepository _SubscritpionRepository ;
      @Autowired
     public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository)
     {
         _SubscritpionRepository = subscriptionRepository ;
     }
    @Override
    public SubscriptionDTO Save(SubscriptionDTO subscriptionDTO) {
        List<String> errors = SubscriptionValidator.validate(subscriptionDTO) ;
        if(!errors.isEmpty())
        {
            log.error("new Subscription is not VALID");
            throw new InvalidEntityException("Invalid Subscription", ErrorCode.SUBSCRIPTION_NOT_VALID,errors) ;
        }
        return SubscriptionDTO.FromEntity(_SubscritpionRepository.save(SubscriptionDTO.ToEntity(subscriptionDTO))) ;
    }

    @Override
    public SubscriptionDTO findByNumSub(Long NumSubscription) {
          if(NumSubscription==null)
          {
              log.error("ERROR");
              return null ;
          }
          Optional<Subscription> subscription = _SubscritpionRepository.findById(NumSubscription) ;
          return Optional.of(SubscriptionDTO.FromEntity(subscription.get())).orElseThrow(()-> new EntityNotFoundException("WE can't find a " +
                  "Subscritpion with that ID ",ErrorCode.SUBSCRIPTION_NOT_FOUND)) ;
    }

    @Override
    public List<SubscriptionDTO> findByStartDate(Date SubscriptionStartDate) {
        return null;
    }

    @Override
    public List<SubscriptionDTO> findAll() {
          return _SubscritpionRepository.findAll().stream().map(SubscriptionDTO::FromEntity).collect(Collectors.toList()) ;
    }

    @Override
    public void Delete(Long NumSubscription) {
          if(NumSubscription==null)
          {
              log.error("Null ID");
              return ;
          }
          _SubscritpionRepository.deleteById(NumSubscription);

    }
}
