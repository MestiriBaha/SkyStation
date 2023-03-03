package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.DTOs.SkierDTO;
import com.baha.TrainingPlatformEE.Models.Skier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkierRepository extends JpaRepository<Skier,Integer> {
    //extends JpaRepository<Integer,Skier>
    //I  think i found the problem it is implementation problem !
    //next time , get to the method to check for the parameters !

    Optional<Skier> findByNumSkier(long num) ;
    
}
