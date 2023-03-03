package com.baha.TrainingPlatformEE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@EntityScan(basePackages = {"com.baha.TrainingPlatformEE.Models"})

@ComponentScan(basePackages = {"com.baha.TrainingPlatformEE.Services.Implementations","com.baha.TrainingPlatformEE.Controllers","com.baha.TrainingPlatformEE.Repositories"})
@EnableJpaRepositories(basePackages = {"com.baha.TrainingPlatformEE.Repositories"})
public class TrainingPlatformEeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingPlatformEeApplication.class, args);
	}

}
