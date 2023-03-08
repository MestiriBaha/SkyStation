package com.baha.TrainingPlatformEE.Services.Implementations;

import com.baha.TrainingPlatformEE.DTOs.SubscriptionDTO;
import com.baha.TrainingPlatformEE.Exceptions.EntityNotFoundException;
import com.baha.TrainingPlatformEE.Exceptions.ErrorCode;
import com.baha.TrainingPlatformEE.Exceptions.InvalidEntityException;
import com.baha.TrainingPlatformEE.Models.Subscription;
import com.baha.TrainingPlatformEE.Models.TypeSubscription;
import com.baha.TrainingPlatformEE.Repositories.SubscriptionRepository;
import com.baha.TrainingPlatformEE.Services.SubscriptionService;
import com.baha.TrainingPlatformEE.Validators.SubscriptionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    public List<SubscriptionDTO> findByStartDate(LocalDate SubscriptionStartDate) {
          if (SubscriptionStartDate ==null)
          { return null ; }
          return _SubscritpionRepository.findByStartDate(SubscriptionStartDate)
                  .stream()
                  .map(SubscriptionDTO::FromEntity)
                  .collect(Collectors.toList()) ;
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

    //Implementation of JPQL methods :
    @Override
    public List<SubscriptionDTO> retrieveSubscriptionsByDate(LocalDate startDate , LocalDate endDate)
    {

        int comparaison = endDate.compareTo(startDate) ;
        if (comparaison==0) {


            log.error("We can't retrieve subscriptions with the Same date");
            return null ;
                }
        if(comparaison<0)
        {
            log.error("the startDate is bigger than the endDate");
            return null ;
        }


        return _SubscritpionRepository.retrieveSubscriptionsByDates(startDate,endDate)
                .stream()
                .map(SubscriptionDTO::FromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Set<SubscriptionDTO> getSubscriptionByType(TypeSubscription type) {
       //look at this
        //Enum type should be transformed into an Array type so we can Iterate it using the values method of ENUM !
        TypeSubscription typeSubscription[] = TypeSubscription.values() ;
        for (TypeSubscription iteration :typeSubscription)
        {
            if(type!=iteration) { log.error("it doesn't exist");
                throw new EntityNotFoundException("the parameter is not a type of ENUM ",ErrorCode.SUBSCRIPTION_NOT_FOUND) ;  }

        }
        return _SubscritpionRepository.getSubscriptionByType(type)
                .stream()
                .map(SubscriptionDTO::FromEntity)
                .collect(Collectors.toSet()) ;
    }
    //public void retrieveSubscriptions() {





}
