package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Subscription;
import com.baha.TrainingPlatformEE.Models.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{
    //extends JpaRepository<Integer,Subscription>

    //JPQL : SELECT Statements all less complexed than other operations haha
    @Query("SELECT subscription FROM Subscription subscription WHERE subscription.StartDate=:startDate " +
            "and subscription.EndDate=:endDate")
    List<Subscription> retrieveSubscriptionsByDates(@Param("startDate") LocalDate startDate,
                                                    @Param("endDate") LocalDate endDate);
    //Native SQL METHOD
    @Query(value = "SELECT * FROM SubscriptionsTable ",nativeQuery = true)
    void retrieveSubscriptions() ;

    @Query("SELECT subscriptions FROM Subscription subscriptions WHERE Subscription.typesubscription=?1")
    Set<Subscription> getSubscriptionByType(TypeSubscription type) ;
    @Query("SELECT subscriptions FROM Subscription subscriptions where Subscription .StartDate=?1")
    List<Subscription> findByStartDate(LocalDate startDate) ;


}
