package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Integer, Course> {
}
