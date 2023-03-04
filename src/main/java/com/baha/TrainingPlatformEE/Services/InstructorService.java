package com.baha.TrainingPlatformEE.Services;

import com.baha.TrainingPlatformEE.DTOs.InstructorDTO;

import java.util.List;

public interface InstructorService {
    InstructorDTO Save (InstructorDTO instructorDTO) ;
    InstructorDTO findByInstructorNum (Long instructorNum) ;
    List<InstructorDTO> findAll() ;

    void Delete (Long InstructorNum)  ;
}
