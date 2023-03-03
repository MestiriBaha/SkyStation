package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{
    //extends JpaRepository<Integer,Subscription>
}
