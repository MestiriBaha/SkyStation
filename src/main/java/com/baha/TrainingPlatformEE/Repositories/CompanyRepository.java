package com.baha.TrainingPlatformEE.Repositories;

import com.baha.TrainingPlatformEE.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,String> {
    //extends JpaRepository<Integer,Company>
}
