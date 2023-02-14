package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {
}
