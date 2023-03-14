package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Models.Skier;
import com.baha.TrainingPlatformEE.Models.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SkierRepository extends JpaRepository<Skier,Long> {
    //extends JpaRepository<Integer,Skier>
    //I  think i found the problem it is implementation problem !
    //next time , get to the method to check for the parameters !

    Optional<Skier> findByNumSkier(long num) ;

    //First JPQL method !! woww !
    @Query("SELECT skier FROM Skier skier WHERE skier.subscription.typesubscription=:subsciptionType")
    List<Skier> retrieveSkiersBySubscriptionType(@Param("subsciptionType") TypeSubscription subscriptionType);
    /*@Modifying
    @Query
    it looks difficult :(
    Skier addSkierAndAssignToCourse(Skier skieur);*/



}
