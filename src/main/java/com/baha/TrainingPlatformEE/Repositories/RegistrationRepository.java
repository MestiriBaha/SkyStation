package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Integer, Registration> {
}
