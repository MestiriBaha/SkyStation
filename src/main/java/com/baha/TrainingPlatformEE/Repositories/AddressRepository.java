package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  {

    //extends JpaRepository<Integer, Address> there is a big problem ! as i know we didn't extend the Adress class from
    //the Abstract Entity !!
}
