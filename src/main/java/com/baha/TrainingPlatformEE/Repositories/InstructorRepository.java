package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Integer, Instructor> {
}
